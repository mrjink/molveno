var active_nav_item = '';

const ACTIVE_ITEM = 'active_item';

const HOME_ITEM = 'home';
const HOTEL_ITEM = 'hotel';
const RESTAURANT_ITEM = 'restaurant';
const EVENT_ITEM = 'event';
const CONTACT_ITEM = 'contact';

const SELECTED_LANGUAGE = 'contact';
const ENGLISH = 'English';
const CHINESE = 'Chinese';

function setCurrentActiveItem(current_active_nav_item)
{
    active_nav_item = current_active_nav_item;
    localStorage.setItem(ACTIVE_ITEM,current_active_nav_item);
}

function performEvent(event_type)
{
    if (event_type == 'login')
    {
        login();
    }else{
        register();
    }
}

function login()
{
    alert("Login header function");

  //    document.getElementById('home_nav_item').innerHTML = "Kitchen Chef";

  //    document.getElementById("restaurant_nav_item").className = "nav-item dropdown active";
   //    document.getElementById("home_nav_item").className = "nav-item";

   //class="nav-item active"


}

function register()
{
    alert("Register");
}

function setLanguage(selected_language)
{
    localStorage.setItem(SELECTED_LANGUAGE,selected_language);
    location.reload();
}
