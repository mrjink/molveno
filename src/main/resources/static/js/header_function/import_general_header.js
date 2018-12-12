

    function includeHTML() {

      console.log('Include html function called!')
        var z, i, elmnt, file, xhttp;
        //Iterate through the collection of all HTML elements:
        z = document.getElementsByTagName("*");
        for (i = 0; i < z.length; i++) {
          elmnt = z[i];

          //Search for elements with a certain atrribute:
          file = elmnt.getAttribute("w3-include-html");
          if (file) {

            //Make an HTTP request using the attribute value as the file name:
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
              if (this.readyState == 4) {
                if (this.status == 200) {
                    elmnt.innerHTML = this.responseText;

                    document.getElementById("home_nav_item").className =  localStorage.getItem(ACTIVE_ITEM) === HOME_ITEM ? "nav-item active" : "nav-item";
                    document.getElementById("hotel_nav_item").className = localStorage.getItem(ACTIVE_ITEM) === HOTEL_ITEM ? "nav-item dropdown active" : "nav-item dropdown";
                    document.getElementById("restaurant_nav_item").className = localStorage.getItem(ACTIVE_ITEM) === RESTAURANT_ITEM ? "nav-item dropdown active" : "nav-item dropdown";
                    document.getElementById("event_nav_item").className = localStorage.getItem(ACTIVE_ITEM) === EVENT_ITEM ? "nav-item dropdown active" : "nav-item dropdown";
                    document.getElementById("contact_nav_item").className = localStorage.getItem(ACTIVE_ITEM) === CONTACT_ITEM ? "nav-item active" : "nav-item";

                    if(localStorage.getItem(SELECTED_LANGUAGE) === '' || localStorage.getItem(SELECTED_LANGUAGE) === ENGLISH)
                    {
                      document.getElementById("language").innerHTML='<ul class="languagepicker"><a href="#en" onclick="setLanguage(ENGLISH);"><li><img src="/img/EN.png"/>English</li></a><a href="#cn" onclick="setLanguage(CHINESE);"><li><img src="/img/CN.png"/>Chinese</li></a></ul>';
                      onEnglishLanguageSelected();
                    }else
                    {
                      document.getElementById("language").innerHTML='<ul class="languagepicker"><a href="#cn" onclick="setLanguage(CHINESE);"><li><img src="/img/CN.png"/>Chinese</li></a><a href="#en" onclick="setLanguage(ENGLISH);"><li><img src="/img/EN.png"/>English</li></a></ul>';
                      onChineseSelected();
                    }
                  }
                if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
                //Remove the attribute, and call this function once more:
                elmnt.removeAttribute("w3-include-html");
                includeHTML();
              }
            }
            xhttp.open("GET", file, true);
            xhttp.send();
            return;
          }
        }
    };
