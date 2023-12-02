window.onload = () => {
    console.log("onload");
    injectFontLink();
    setFavicon();
    let footerContent = footer();
    const main = document.querySelector("main");
    main.insertAdjacentHTML("afterend", footerContent);
    
    const octocat = document.getElementById("octocat");
        octocat.addEventListener('click', function(event) {
        window.location.href = "https://github.com/DankoCaboski";
        }
    );;

}

function injectFontLink() {
    console.log("injectFontLink");
    var fontLink = document.createElement("link");
    fontLink.setAttribute("href", "https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap");
    fontLink.setAttribute("rel", "stylesheet");
    document.head.appendChild(fontLink);
}

function setFavicon() {
    console.log("setFavicon");
    var shortcutIcon = document.querySelector("link[rel='shortcut icon']");
    if (shortcutIcon) {
        shortcutIcon.href = "favicon.ico";
    } else {
        shortcutIcon = document.createElement("link");
        shortcutIcon.setAttribute("rel", "shortcut icon");
        shortcutIcon.setAttribute("href", "/demo/src/main/frontend/assets/favicon.ico");
        document.head.appendChild(shortcutIcon);
        
    }
    
    var icon = document.querySelector("link[rel*='icon']");
    if (icon) {
        icon.href =  "/demo/src/main/frontend/assets/favicon.ico";
    }
}

function footer(){
    return `
    <footer id="footer">
    <p>&copy; 2023 Willian Caboski</p>
    <svg id="octocat" height="32" aria-hidden="true" viewBox="0 0 16 16" version="1.1" width="32" data-view-component="true" class="octicon octicon-mark-github v-align-middle color-fg-default">
        <defs>
            <style>
                .octicon.octicon-mark-github path {
                    filter: invert(1);
                }
            </style>
        </defs>
        <path d="M8 0c4.42 0 8 3.58 8 8a8.013 8.013 0 0 1-5.45 7.59c-.4.08-.55-.17-.55-.38 0-.27.01-1.13.01-2.2 0-.75-.25-1.23-.54-1.48 1.78-.2 3.65-.88 3.65-3.95 0-.88-.31-1.59-.82-2.15.08-.2.36-1.02-.08-2.12 0 0-.67-.22-2.2.82-.64-.18-1.32-.27-2-.27-.68 0-1.36.09-2 .27-1.53-1.03-2.2-.82-2.2-.82-.44 1.1-.16 1.92-.08 2.12-.51.56-.82 1.28-.82 2.15 0 3.06 1.86 3.75 3.64 3.95-.23.2-.44.55-.51 1.07-.46.21-1.61.55-2.33-.66-.15-.24-.6-.83-1.23-.82-.67.01-.27.38.01.53.34.19.73.9.82 1.13.16.45.68 1.31 2.69.94 0 .67.01 1.3.01 1.49 0 .21-.15.45-.55.38A7.995 7.995 0 0 1 0 8c0-4.42 3.58-8 8-8Z"></path>
    </svg>
</footer>
`;
}


