const express = require("express");

const app = express();

app
    .get("/late-request", async (req, res) => {
        console.log("Request")
        await new Promise(res => setTimeout(() => {
            res();
            console.log("Promise resolve")
        }, 5000))
        res.send("Late Request");
    })
    .on("error", _ => console.log("Error on request"));

app.listen(process.env.LATE_REQUEST_PORT || 8080, () => {
    console.log("Server ready late request");
}).on("error", (e) => {
    console.error("Server NOT ready!");
});