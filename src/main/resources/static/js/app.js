/**
 * RepMaster JavaScript
 *
 * This file controls the behaviour
 * of buttons and page interactions.
 */

/* =============================================== */
/* LOGIN BUTTON */
/* =============================================== */

/* Get the login button from the page */
const loginButton = document.getElementById("loginButton");

if (loginButton) {

    /* When the login button is clicked */
    loginButton.addEventListener("click", async function (event) {

        event.preventDefault(); // Stop form from refreshing the page

        // Get username and password from inputs
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        // Build the login request object
        const loginRequest = {
            username: username,
            password: password
        };

        try {

            // Send login request to backend
            const response = await fetch("/api/login", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loginRequest)

            });

            // If login is successful
            if (response.ok) {

                const user = await response.json();

                // Save user info for later use
                localStorage.setItem("userId", user.id);
                localStorage.setItem("userName", user.firstName);

                // Go to dashboard
                window.location.href = "dashboard.html";

            } else {

                // Show error message from backend
                const message = await response.text();

               showNotification(message);

            }

        } catch (error) {

            console.error(error);

           alert("Something went wrong.");

        }

    });

}

/* =============================================== */
/* REGISTER BUTTON */
/* =============================================== */

/* Get the register button */
const registerButton = document.getElementById("registerButton");

if (registerButton) {

    /* When register button is clicked */
    registerButton.addEventListener("click", async function (event) {

        event.preventDefault(); // Stop page refresh

         // Get all input values
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const phoneNumber = document.getElementById("phoneNumber").value;
        const password = document.getElementById("password").value;

        // Build the register request object
        const registerRequest = {
            firstName: firstName,
            lastName: lastName,
            username: username,
            email: email,
            phoneNumber: phoneNumber,
            password: password

        };

        try {

            // Send registration request
            const response = await fetch("/api/register", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(registerRequest)

            });
            // Show backend message
            const result = await response.text();
            showNotification(result);

        } catch (error) {

            console.error(error);

           alert("Registration failed.");

        }

    });

}

/* =============================================== */
/* PAGE SECTIONS AND BUTTONS */
/* =============================================== */

/* Get page sections and buttons */
const home = document.querySelector(".home")
const homeButton = document.getElementById("homeButton");
const dashboard = document.querySelector(".dashboard");
const createWorkoutButton = document.getElementById("createWorkoutButton");
const myWorkoutsButton = document.getElementById("myWorkoutsButton");
const createWorkoutSection = document.getElementById("createWorkoutSection");
const myWorkoutsSection = document.getElementById("myWorkoutsSection");
const workoutLoggerButton = document.getElementById("workoutLoggerButton");
const loggerSection = document.getElementById("loggerSection");
const todayWorkoutSection = document.getElementById("todayWorkoutSection");
const historySection = document.getElementById("historySection");
const workoutLoggerForm = document.getElementById("workoutLoggerForm");
const saveLogButton = document.getElementById("saveLogButton");

let currentWorkoutId = null;  // Stores selected workout ID
let workoutList = []; // Stores all workouts


/* =============================================== */
/* CREATE WORKOUT BUTTON */
/* =============================================== */
if (createWorkoutButton) {

    createWorkoutButton.addEventListener("click", function () {

        home.style.display = "none";  // Hide home page
        dashboard.style.display = "flex";  // Show dashboard

        showSection(createWorkoutSection); // Show create workout section

    });

}

/* =============================================== */
/* MY WORKOUTS BUTTON */
/* =============================================== */

if (myWorkoutsButton) {

    myWorkoutsButton.addEventListener("click", function () {

        home.style.display = "none"; // Hide home page
        dashboard.style.display = "flex"; // Show dashboard

        showSection(myWorkoutsSection); // Show workouts section

        loadWorkouts(); // Load workouts from backend

    });


}
/* =============================================== */
/* TODAY'S WORKOUT BUTTON */
/* =============================================== */

const todayWorkoutButton = document.getElementById("todayWorkoutButton");

if (todayWorkoutButton) {

    todayWorkoutButton.addEventListener("click", function () {

        // Show a simple "coming soon" popup
        showComingSoonModal();

    });

}

// =====================================================
// Workout History
// =====================================================
const workoutHistoryButton = document.getElementById("workoutHistoryButton");

if (workoutHistoryButton) {

    workoutHistoryButton.addEventListener("click", function () {

        home.style.display = "none"; // Hide home page
        dashboard.style.display = "flex";  // Show dashboard

        showSection(historySection); // Show workout history section

        loadWorkoutHistory(); // Load history from backend

    });

}

// =====================================================
// Workout Logger Button
// =====================================================
if (workoutLoggerButton) {

    workoutLoggerButton.addEventListener("click", function () {

        home.style.display = "none"; // Hide home page
        dashboard.style.display = "flex"; // Show dashboard

        showSection(loggerSection); // Show workout logger section

        loadWorkoutNames(); // Load workout names for dropdown
        loadWorkoutLogs(); // Load previous logs

    });

}

// =====================================================
// Home Button
// =====================================================
 if (homeButton) {

     homeButton.addEventListener("click", function () {

         dashboard.style.display = "none"; // Hide dashboard
         home.style.display = "flex"; // Show home page

     });

 }

// =====================================================
// Dashboard Section Controls
// =====================================================

/* Hides all dashboard sections */
 function hideAllSections() {

     createWorkoutSection.style.display = "none";
     myWorkoutsSection.style.display = "none";

 }

/* Shows one specific section */
 function showSection(section) {

     hideAllSections(); // Hide everything first
     section.style.display = "block"; // Show selected section

 }

 // =====================================================
 // Welcome Message
 // =====================================================
 const userName = localStorage.getItem("userName");

 if (userName) {

     document.getElementById("welcomeMessage").textContent =
         `Welcome back, ${userName}!`;

 }

// =====================================================
// Create Workout Form
// =====================================================
const createWorkoutForm = document.getElementById("createWorkoutForm");
const saveButton = document.getElementById("saveButton");

if (saveButton) {

    saveButton.addEventListener("click", async function (event) {

            event.preventDefault(); // Stop page refresh

            // Get form values
            const workoutName = document.getElementById("workoutName").value;
            const targetMuscle = document.getElementById("targetMuscle").value;
            const exercises = document.getElementById("exercises").value;
            const sets = document.getElementById("sets").value;
            const reps = document.getElementById("reps").value;

           // Build workout request object
           const workoutRequest = {

               userId: localStorage.getItem("userId"),

               workoutName: workoutName,
               targetMuscle: targetMuscle,
               exercises: exercises,
               sets: sets,
               reps: reps

           };
           try {

               let url = "/api/workout";  // Default: create new workout
               let method = "POST";

               // If editing an existing workout, use PUT instead of POST
               if (currentWorkoutId !== null) {

                   url = `/api/workout/${currentWorkoutId}`;
                   method = "PUT";

               }
                // Send request to backend
               const response = await fetch(url, {

                   method: method,

                   headers: {
                       "Content-Type": "application/json"
                   },

                   body: JSON.stringify(workoutRequest)

               });

               const result = await response.text();

               showNotification(result); // Show backend message
               createWorkoutForm.reset(); // Clear form
               currentWorkoutId = null; // Reset edit mode

               document.getElementById("saveButton").textContent = "Create Workout";  // Reset button text

               loadWorkouts();  // Reload workouts
               showSection(myWorkoutsSection);  // Go back to workouts list

           } catch (error) {

               console.error(error);

               alert("Workout could not be saved.");

           }

    });

}// =====================================================
 // Load all workouts from the database
 // =====================================================
async function loadWorkouts() {

    try {

        const userId = localStorage.getItem("userId");

        const response = await fetch("/api/workouts?userId=" + userId);

        const workouts = await response.json();

        workoutList = workouts; // Save list globally

        displayWorkouts(workouts); // Show workouts on page

    } catch (error) {

        console.error("Error loading workouts:", error);

    }

}

 // =====================================================
 // Load workouts into logger dropdown
 // =====================================================

async function loadWorkoutNames() {

    try {

        const userId = localStorage.getItem("userId");

        const response = await fetch("/api/workouts?userId=" + userId);

        const workouts = await response.json();

        const workoutDropdown = document.getElementById("logWorkoutName");

        // Default option
        workoutDropdown.innerHTML = `
            <option value="" selected disabled>
                Select a workout
            </option>
        `;
        // Add each workout to dropdown
        workouts.forEach(workout => {

            workoutDropdown.innerHTML += `
                <option value="${workout.id}">
                    ${workout.workoutName}
                </option>
            `;

        });

    } catch (error) {

        console.error(error);

       alert("Could not load workouts.");

    }

}

 // =====================================================
 // Display workouts on the page
 // =====================================================

 function displayWorkouts(workouts) {

     const workoutsContainer = document.getElementById("workoutsContainer");

     workoutsContainer.innerHTML = ""; // Clear previous workouts

     workouts.forEach(workout => {

         // Add each workout as a card
         workoutsContainer.innerHTML += `

             <div class="workout-item">

                 <h3>${workout.workoutName}</h3>

                 <p><strong>Target Muscle:</strong> ${workout.targetMuscle}</p>

                 <p><strong>Exercises:</strong> ${workout.exercises}</p>

                 <p><strong>Sets:</strong> ${workout.sets}</p>

                 <p><strong>Reps:</strong> ${workout.reps}</p>

                 <button onclick="editWorkout(${workout.id})">

                     ✏️ Edit

                 </button>

                 <button onclick="deleteWorkout(${workout.id})">

                     🗑️ Delete

                 </button>


             </div>

         `;

     });

 }
 // =====================================================
 // Edit workout
 // =====================================================

async function editWorkout(id) {

    currentWorkoutId = id; // Store the workout ID being edited

    // Find the workout in the list
    const workout = workoutList.find(workout => workout.id === id);

    // Fill the form with existing values
    document.getElementById("workoutName").value = workout.workoutName;
    document.getElementById("targetMuscle").value = workout.targetMuscle;
    document.getElementById("exercises").value = workout.exercises;
    document.getElementById("sets").value = workout.sets;
    document.getElementById("reps").value = workout.reps;

    // Show the create workout section
    showSection(createWorkoutSection);

    // Change button text to "Update"
    document.getElementById("saveButton").textContent = "Update Workout";

}

// =====================================================
// Delete workout
// =====================================================

async function deleteWorkout(id) {

    // Ask the user to confirm before deleting
    const confirmed = confirm("Are you sure you want to delete this workout?");

    if (!confirmed) {
        return; // Stop if user cancels
    }

    try {
         // Send delete request
        const response = await fetch(`/api/workout/${id}`, {

            method: "DELETE"

        });

        const result = await response.text();

        showNotification(result);  // Show backend message

        // Reload the workouts so the deleted workout disappears
        loadWorkouts();

    } catch (error) {

        console.error(error);

       alert("Workout deletion failed.");

    }

}

// =====================================================
// Hide all dashboard sections
// =====================================================
function hideAllSections() {

    createWorkoutSection.style.display = "none";
    myWorkoutsSection.style.display = "none";
    todayWorkoutSection.style.display = "none";
    loggerSection.style.display = "none";
    historySection.style.display = "none";

}

// =====================================================
// Save Workout Log
// =====================================================

if (saveLogButton) {

    saveLogButton.addEventListener("click", async function (event) {

        event.preventDefault();

        const workoutId = document.getElementById("logWorkoutName").value;

        // Validate workout selection
        if (!workoutId) {

           alert("Please select a workout.");

            return;

        }

        // Get log details
        const workoutDate = document.getElementById("logWorkoutDate").value;
        const duration = document.getElementById("logDuration").value;
        const notes = document.getElementById("logNotes").value;

       // Build request object
       const workoutLogRequest = {
           userId: localStorage.getItem("userId"),
           workoutId: workoutId,
           workoutDate: workoutDate,
           duration: duration,
           notes: notes

       };

        try {
            // Send log to backend
            const response = await fetch("/api/workout-log", {

                method: "POST",

                headers: {

                    "Content-Type": "application/json"

                },

                body: JSON.stringify(workoutLogRequest)

            });

            const result = await response.text();

           showNotification(result);  // Show backend message

            workoutLoggerForm.reset(); // Clear form

            // Return the dropdown to the placeholder
            document.getElementById("logWorkoutName").selectedIndex = 0;

            loadWorkoutLogs(); // Refresh logs

        } catch (error) {

            console.error(error);

            alert("Could not save workout log.");

        }

    });

}
// =====================================================
// Load Workout Logs
// =====================================================

async function loadWorkoutLogs() {

    try {

       const userId = localStorage.getItem("userId");

       const response = await fetch("/api/workout-logs?userId=" + userId);

       const workoutLogs = await response.json();

       displayWorkoutLogs(workoutLogs);

    } catch (error) {

        console.error(error);

       alert("Could not load workout logs.");

    }

}

// =====================================================
// Display Workout Logs
// =====================================================

function displayWorkoutLogs(logs) {

    const container = document.getElementById("workoutLogsContainer");

    container.innerHTML = ""; // Clear previous logs

    logs.forEach(log => {

        container.innerHTML += `

            <div class="workout-item">

                <h3>${log.workout.workoutName}</h3>

                <p><strong>Date:</strong> ${log.workoutDate}</p>

                <p><strong>Duration:</strong> ${log.duration} minutes</p>

                <p><strong>Notes:</strong> ${log.notes}</p>

            </div>

        `;

    });

}

// =====================================================
// Coming Soon Modal
// =====================================================
function showComingSoonModal() {
    document.getElementById("comingSoonModal").style.display = "block";
}
function closeComingSoonModal() {
    document.getElementById("comingSoonModal").style.display = "none";
}


// =====================================================
// Load Workout History
// =====================================================

async function loadWorkoutHistory() {

    try {

        const userId = localStorage.getItem("userId");

        const response = await fetch("/api/workout-logs?userId=" + userId);

        const logs = await response.json();

        displayWorkoutHistory(logs);

    } catch (error) {

        console.error(error);

    }

}

// =====================================================
// Display Workout History
// =====================================================
function displayWorkoutHistory(logs) {

    const historyContainer = document.getElementById("historyContainer");

    historyContainer.innerHTML = "";

    if (logs.length === 0) {

        historyContainer.innerHTML = "<p>No workout history yet.</p>"; // Clear previous history

        return;

    }

    logs.forEach(log => {

        historyContainer.innerHTML += `

            <div class="workout-item">

                <h3>${log.workout.workoutName}</h3>

                <p><strong>Date:</strong> ${log.workoutDate}</p>

                <p><strong>Duration:</strong> ${log.duration} minutes</p>

                <p><strong>Notes:</strong> ${log.notes}</p>

            </div>

        `;

    });

}

// =====================================================
// Notification Popup
// =====================================================
function showNotification(message) {

    const notification = document.getElementById("notification");

    notification.textContent = message; // Set message

    notification.classList.add("show");  // Slide in

    setTimeout(function () {
        notification.classList.remove("show"); // Hide after 3s
    }, 3000);
}

// =====================================================
// Logout Button
// =====================================================

const logoutButton = document.getElementById("logoutButton");

if (logoutButton) {

    logoutButton.addEventListener("click", function () {

        const confirmLogout = confirm("Are you sure you want to log out?");

        if (confirmLogout) {

            localStorage.clear(); // Remove saved user data

            window.location.href = "login.html"; // Go to login page

        }

    });

}
