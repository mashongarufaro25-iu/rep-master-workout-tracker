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

        // Prevent page refresh
        event.preventDefault();

        // Read values from the text boxes
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {

            // Send the data to Spring Boot
            const response = await fetch("/api/login", {

                method: "POST",

                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },

                body: new URLSearchParams({
                    username: username,
                    password: password
                })

            });

            // Read Spring Boot's reply
            const result = await response.text();

            alert(result);

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

    registerButton.addEventListener("click", function () {

        alert("Registration feature coming soon!");

    });

}