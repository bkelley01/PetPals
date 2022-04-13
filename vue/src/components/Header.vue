<template>
  <div class="header">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <div class="logo">
      <img class="petpals-logo" src="@/images/petpals.png" />
      <!-- <div class="header-options"> commented out for modal menu -->
        <!-- <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''" >Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >&nbsp;|&nbsp;Logout</router-link> -->
        <!-- <p v-on:click="showHideMenu">Menu</p>
          <ul v-show="showMenu" id="menu-list">
            <li class="menu-item">Profile</li>
            <li class="menu-item">Playdates</li>
            <li class="menu-item">Messages</li>
            <li v-if="$store.state.token != ''" class="menu-item"><router-link v-bind:to="{ name: 'logout' }" >Logout</router-link></li>
            <li v-if="$store.state.token == ''" class="menu-item"><router-link v-bind:to="{ name: 'login' }" >Login</router-link></li>
          </ul>
      </div> commented out for modal menu -->
      <menu-panel v-if="showMenu"></menu-panel>
      <p id="menu-btn" v-on:click="showHideMenu">☰</p>
      
    </div>
    <div class="menu">
      <div class="my-pets"></div>
    </div>
  </div>
</template>

<script>
import menuPanel from '@/components/Menu.vue';

export default {
  components: { menuPanel },
  data() {
    return {
      showMenu: false,
    }
  },

  methods: {
    showHideMenu() {
      //this.showMenu === false ? this.showMenu = true : this.showMenu = false;
      this.showMenu = !this.showMenu;
    }
  }
}

</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap');

* {
  font-family: 'Montserrat', sans-serif;
}

html {
  background-color: #f0f2f5;
}

.header {
  background-color: #f0f2f5;
}

.logo {
  display: flex;
  flex-direction: row;
  align-items: center;
  /* font-size: 1.5rem; */
  text-decoration: none;
  justify-content: space-between;
}

.petpals-logo {
  height: auto;
  width: 150px;
}

.header-options {
  font-size: 1.5em;
}

router-link {
  text-decoration: none;
}

/* Menu */
ul { 
  list-style: none outside none; 
  margin:0; 
  padding: 0; 
  }
li { 
  float: right;
  margin: 0 10px; 
  position: relative;
  }

p#menu-btn {
  font-size: 25px;
  padding: 0 3px 0 3px;
  margin-right: 2%;
  border: 2px solid black;
}


</style>