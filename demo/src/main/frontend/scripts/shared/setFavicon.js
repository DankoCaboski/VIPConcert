var shortcutIcon = document.querySelector("link[rel='shortcut icon']");
if (shortcutIcon) {
    shortcutIcon.href = "favicon.ico";
} else {
    shortcutIcon = document.createElement("link");
    shortcutIcon.setAttribute("rel", "shortcut icon");
    shortcutIcon.setAttribute("href", "/demo/src/main/frontend/assets/favicon.ico");
    document.head.appendChild(shortcutIcon);
    console.log("shortcutIcon", shortcutIcon);

}

var icon = document.querySelector("link[rel*='icon']");
if (icon) {
    icon.href =  "/demo/src/main/frontend/assets/favicon.ico";
}