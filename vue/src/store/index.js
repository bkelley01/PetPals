import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    showMenu: false, // added for menu
    showManagePetsOption: false,
    playdateFilter: {
      playdateTitle: "",
      playdateLocation: "",
      playdateDate: ""
    },
    personalityOptions: ['Friendly', 'Curious', 'Playful', 
                          'Happy', 'Social', 'Individualistic', 
                          'Loyal', 'Easy-going', 'Helpful'],
    fakeUsers: [
      {
        userId: 1,
        username: "user",
        pets: [ 
          {
          petId: 1,
          name: "Spot",
          personalities: ["Energetic", "Happy"],
          type: "Dog"
          }
        ],
        playdates: [1, 2]

      },
      {
        userId: 2,
        username: "michael",
        pets: [
          {
            petId: 2,
            name: "Sparky",
            personalities: ["Lazy", "Hungry"],
            type: "Dog"
          },
          {
            petId: 3,
            name: "Marley",
            personalities: ["Fast", "Happy"],
            type: "Dog"
          },
        ],
        playdates: [1, 2]

      },
      {
        userId: 3,
        username: "steve",
        pets: [],
        playdates: []
      }
    ],
    messages: [
      { 
        messageId: 1,
        sender: "user",
        message: "Spot had such a fun time hanging out with Sparky and Marley! Two top class puppers!"
      },
      {
        messageId: 2,
        sender: "michael",
        message: "Hosting a doggie hangout at Summit Park on May 22nd. Open to all dogs who want to come!"
      }
    ],
    playdates: [
      {
        playdateId: 1,
        title: "Spot's Birthday Party",
        location: "Winton Woods",
        date: "2022-04-22",
        startTime: "2:00:00 PM",
        endTime: "4:00:00 PM",
        host: "jerry",
        numPetsAttending: 3,
        petsAttending: ["Spot", "Sparky", "Marley"]
      },
      {
        playdateId: 2,
        title: "Spring into Summit",
        location: "Summit Park",
        date: "2022-05-22",
        startTime: "1:00:00 PM",
        endTime: "3:00:00 PM",
        host: "michael",
        numPetsAttending: 4,
        petsAttending: ["Spot", "Sparky", "Marley", "Air Bud"]
      },
    ]
  },
  mutations: {
    SET_SHOW_MENU(state) { // mutation to adjust showMenu variable above
      state.showMenu = !state.showMenu;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    TOGGLE_MANAGE_PETS(state) { // mutation to adjust manage button
      state.showManagePetsOption = !state.showManagePetsOption;
    },

    FILTER_PLAYDATES(state, filterObject) {
      state.playdateFilter = filterObject;
    }
  }
})
