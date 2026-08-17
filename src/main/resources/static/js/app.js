/**
 * RepMaster JavaScript
 *
 * This file controls the behaviour
 * of buttons and page interactions.
 */



/*
 * Login Button
 */
const loginButton = document.getElementById("loginButton");

if (loginButton) {

    loginButton.addEventListener("click", async function (event) {

        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        const loginRequest = {

            username: username,
            password: password

        };

        try {

            const response = await fetch("/api/login", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(loginRequest)

            });

            if (response.ok) {

                const user = await response.json();

                localStorage.setItem("userId", user.id);
                localStorage.setItem("userName", user.firstName);

                window.location.href = "dashboard.html";

            } else {

                const message = await response.text();

               showNotification(message);

            }



        } catch (error) {

            console.error(error);

           alert("Something went wrong.");

        }

    });

}

/*
 * Register button
 */
const registerButton = document.getElementById("registerButton");

if (registerButton) {

    registerButton.addEventListener("click", async function (event) {

        event.preventDefault();

        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const phoneNumber = document.getElementById("phoneNumber").value;
        const password = document.getElementById("password").value;

        const registerRequest = {

            firstName: firstName,
            lastName: lastName,
            username: username,
            email: email,
            phoneNumber: phoneNumber,
            password: password

        };

        try {

            const response = await fetch("/api/register", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(registerRequest)



            });

            const result = await response.text();

           showNotification(result);

        } catch (error) {

            console.error(error);

           alert("Registration failed.");

        }

    });

}

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
let currentWorkoutId = null;
let workoutList = [];

/*
 * Create workout  button
 * And home button to allow return to home page
 */
if (createWorkoutButton) {

    createWorkoutButton.addEventListener("click", function () {

        home.style.display = "none";

        dashboard.style.display = "flex";

        showSection(createWorkoutSection);

    });

}

if (myWorkoutsButton) {

    myWorkoutsButton.addEventListener("click", function () {

        home.style.display = "none";

        dashboard.style.display = "flex";

        showSection(myWorkoutsSection);

        loadWorkouts();

    });


}
/*
 * Today's Workout button
 */
const todayWorkoutButton = document.getElementById("todayWorkoutButton");

if (todayWorkoutButton) {

    todayWorkoutButton.addEventListener("click", function () {

        showComingSoonModal();

    });

}

// =====================================================
// Workout History
// =====================================================
const workoutHistoryButton = document.getElementById("workoutHistoryButton");

if (workoutHistoryButton) {

    workoutHistoryButton.addEventListener("click", function () {

        home.style.display = "none";

        dashboard.style.display = "flex";

        showSection(historySection);

        loadWorkoutHistory();

    });

}

if (workoutLoggerButton) {

    workoutLoggerButton.addEventListener("click", function () {

        home.style.display = "none";

        dashboard.style.display = "flex";

        showSection(loggerSection);

        loadWorkoutNames();

        loadWorkoutLogs();

    });

}


 if (homeButton) {

     homeButton.addEventListener("click", function () {

         dashboard.style.display = "none";

         home.style.display = "flex";

     });

 }

 /*
  * Dashboard sections
  */

 function hideAllSections() {

     createWorkoutSection.style.display = "none";
     myWorkoutsSection.style.display = "none";

 }

 function showSection(section) {

     hideAllSections();

     section.style.display = "block";

 }
 const userName = localStorage.getItem("userName");

 if (userName) {

     document.getElementById("welcomeMessage").textContent =
         `Welcome back, ${userName}!`;

 }

const createWorkoutForm = document.getElementById("createWorkoutForm");
const saveButton = document.getElementById("saveButton");

if (saveButton) {

    saveButton.addEventListener("click", async function (event) {

            event.preventDefault();

            const workoutName = document.getElementById("workoutName").value;
            const targetMuscle = document.getElementById("targetMuscle").value;
            const exercises = document.getElementById("exercises").value;
            const sets = document.getElementById("sets").value;
            const reps = document.getElementById("reps").value;




           const workoutRequest = {

               userId: localStorage.getItem("userId"),

               workoutName: workoutName,
               targetMuscle: targetMuscle,
               exercises: exercises,
               sets: sets,
               reps: reps

           };
           try {

               let url = "/api/workout";
               let method = "POST";

               // If editing an existing workout, use PUT instead of POST
               if (currentWorkoutId !== null) {

                   url = `/api/workout/${currentWorkoutId}`;
                   method = "PUT";

               }

               const response = await fetch(url, {

                   method: method,

                   headers: {
                       "Content-Type": "application/json"
                   },

                   body: JSON.stringify(workoutRequest)

               });

               const result = await response.text();

               showNotification(result);

               createWorkoutForm.reset();

               currentWorkoutId = null;

               document.getElementById("saveButton").textContent = "Create Workout";

               loadWorkouts();

               showSection(myWorkoutsSection);

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

        workoutList = workouts;

        displayWorkouts(workouts);

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

        workoutDropdown.innerHTML = `
            <option value="" selected disabled>
                Select a workout
            </option>
        `;

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

     workoutsContainer.innerHTML = "";

     workouts.forEach(workout => {

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

    currentWorkoutId = id;



    const workout = workoutList.find(workout => workout.id === id);

    document.getElementById("workoutName").value = workout.workoutName;
    document.getElementById("targetMuscle").value = workout.targetMuscle;
    document.getElementById("exercises").value = workout.exercises;
    document.getElementById("sets").value = workout.sets;
    document.getElementById("reps").value = workout.reps;

    showSection(createWorkoutSection);

    document.getElementById("saveButton").textContent = "Update Workout";

}

// =====================================================
// Delete workout
// =====================================================

async function deleteWorkout(id) {

    // Ask the user to confirm before deleting
    const confirmed = confirm("Are you sure you want to delete this workout?");

    if (!confirmed) {

        return;

    }

    try {

        const response = await fetch(`/api/workout/${id}`, {

            method: "DELETE"

        });

        const result = await response.text();

        showNotification(result);

        // Reload the workouts so the deleted workout disappears
        loadWorkouts();

    } catch (error) {

        console.error(error);

       alert("Workout deletion failed.");

    }

}

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

        const workoutDate = document.getElementById("logWorkoutDate").value;
        const duration = document.getElementById("logDuration").value;
        const notes = document.getElementById("logNotes").value;

       const workoutLogRequest = {

           userId: localStorage.getItem("userId"),

           workoutId: workoutId,
           workoutDate: workoutDate,
           duration: duration,
           notes: notes

       };

        try {

            const response = await fetch("/api/workout-log", {

                method: "POST",

                headers: {

                    "Content-Type": "application/json"

                },

                body: JSON.stringify(workoutLogRequest)

            });

            const result = await response.text();

           showNotification(result);

            workoutLoggerForm.reset();

            // Return the dropdown to the placeholder
            document.getElementById("logWorkoutName").selectedIndex = 0;

            loadWorkoutLogs();

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

    container.innerHTML = "";

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

/*
 * Opens the Coming Soon modal.
 */
function showComingSoonModal() {

    document.getElementById("comingSoonModal").style.display = "block";

}

/*
 * Closes the Coming Soon modal.
 */
function closeComingSoonModal() {

    document.getElementById("comingSoonModal").style.display = "none";

}
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

function displayWorkoutHistory(logs) {

    const historyContainer = document.getElementById("historyContainer");

    historyContainer.innerHTML = "";

    if (logs.length === 0) {

        historyContainer.innerHTML = "<p>No workout history yet.</p>";

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

/**
 * Displays a notification message.
 *
 * @param message The message to display.
 */
function showNotification(message) {

    const notification = document.getElementById("notification");

    notification.textContent = message;

    notification.classList.add("show");

    setTimeout(function () {
        notification.classList.remove("show");
    }, 3000);
}

/*
 * Logout Button
 */

const logoutButton = document.getElementById("logoutButton");

if (logoutButton) {

    logoutButton.addEventListener("click", function () {

        const confirmLogout = confirm("Are you sure you want to log out?");

        if (confirmLogout) {

            localStorage.clear();

            window.location.href = "login.html";

        }

    });

}
