var ws = new WebSocket("ws://localhost:9998/test");
ws.onopen = function (event) {
	console.log('Send Message');
	ws.send("Message to send");
}
