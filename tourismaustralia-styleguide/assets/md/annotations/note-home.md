### jquery.ta.hotornot.js - controls the interactivity of the hotornot container
### hotornot-item is-hidden - each hotornot-item should be added with the is-hidden state then is should be removed once in the DOM, this will trigger the display to show it
### hotornot-selector1-btn - when the button is clicked it removes the ".is-hidden" class from the "hotornot-item", the CMS will need to generate this data and the target the new content
### hotornot-selector2-btn - when the button is clicked it removes the ".is-hidden" class from the "hotornot-item", the CMS will need to generate this data and the target the new content
### .hotornot-close-btn -  each tile has a close button which will add the .is-hidden class to the tile, thus hiding it, you may wish to remove it from the DOM when the transition is complete
### hotornot-item-padding theme-aboriginal - this styles the tile with the theme (the background and the text colour)
### hotornot-diamond-img-bg theme-aboriginal -  - this styles the diamond background to use the same colour as the theme colour
### .hotornot-close-btn may be required to be black or white depending on the theme type (imgs/icons/close_button_white_std.png and imgs/icons/close_button_white_rol.png, or imgs/icons/close_button_black_std.png or imgs/icons/close_button_black_rol.png)