var link = document.querySelector('link[rel=import]');
var menu = link.import.querySelector('#menu');
document.body.appendChild(menu.cloneNode(true));