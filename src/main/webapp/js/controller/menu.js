var link = document.querySelector('link[rel=import]');
var menu = link.import.querySelector('template');
document.body.appendChild(document.importNode(menu.content, true));