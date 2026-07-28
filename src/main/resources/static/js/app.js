/**
 * RepMaster JavaScript
 *
 * This file controls the behaviour
 * of buttons and page interactions.
 */

console.log("RepMaster loaded successfully.");

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

            const result = await response.text();

            if (result === "Login successful!") {

                window.location.href = "dashboard.html";

            } else {

                alert(result);

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

            alert(result);

        } catch (error) {

            console.error(error);

            alert("Registration failed.");

        }

    });

}

/*
 * Create workout  button
 * And home button to allow return to home page
 */

const home = document.querySelector(".home")
const homeButton = document.getElementById("homeButton");
const dashboard = document.querySelector(".dashboard");
const createWorkoutButton = document.getElementById("createWorkoutButton");

 if(createWorkoutButton){
     createWorkoutButton.addEventListener("click", function(){
               home.style.display = "none";
               dashboard.style.display = "flex";
     });
 }
 if (homeButton) {

     homeButton.addEventListener("click", function () {

         dashboard.style.display = "none";

         home.style.display = "flex";

     });

 }


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
                workoutName: workoutName,
                targetMuscle: targetMuscle,
                exercises: exercises,
                sets: sets,
                reps: reps,

            };
            try {

                        const response = await fetch("/api/workout", {

                            method: "POST",

                            headers: {
                                "Content-Type": "application/json"
                            },

                            body: JSON.stringify(workoutRequest)

                        });

                        const result = await response.text();

                        alert(result);

            } catch (error) {

                        console.error(error);

                        alert("Workout creation failed.");
            }

    });

}