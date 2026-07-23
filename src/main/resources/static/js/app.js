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