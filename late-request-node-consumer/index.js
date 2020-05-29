const express = require("express");

const app = express();

const fetch = require("node-fetch");

const lateRequestUrl = `http://late-request:${process.env.LATE_REQUEST_PORT}/late-request`;

app
    .get("/node/request", async (req, res) => {
        console.log("Node Request");
        var text = "Node: "
        try {
            console.log(`URL: ${lateRequestUrl}`);
            const response = await fetch(lateRequestUrl);
            text += await response.text();
        } catch (error) {
            text = "ERROR";
            console.error("Error");
        }

        res.send(text);
    })
    .on("error", _ => console.log("Error on request"));

app.listen(process.env.LATE_REQUEST_PORT_CONSUMER || 8080, () => {
    console.log("Server ready late request consumer - node");
}).on("error", (e) => {
    console.error("Server NOT ready!");
});