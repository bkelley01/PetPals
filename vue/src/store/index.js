import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import userService from '@/services/UserService.js';

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
    locationOptions: 
    [
      {locationName: 'Summit Park', neighborhood: 'Blue Ash'},
      {locationName: 'Washington Park', neighborhood: 'OTR'},
      {locationName: 'Winton Woods', neighborhood: 'Sharonville'},
      {locationName: 'Fido Field', neighborhood: 'Downtown'},
      {locationName: 'Eden Park', neighborhood: 'Mt. Adams'},
    ],
    userList: []
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
    },
    UPDATE_USER_LIST(state) {
      userService.getAllUsers().then(response => {
        state.userList = response.data;
      });
    }
  }
})
