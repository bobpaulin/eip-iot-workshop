var ws = new WebSocket("ws://localhost:9998/blink");
ws.onopen = function (event) {
	console.log('Send Message');
	ws.send("red");
	ws.send("blue");
}
