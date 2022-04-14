<template>
  <div class="header">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <div id="banner">
      <img class="petpals-logo" src="@/images/petpals.png" />
      <div class="desktop-menu">
        <menu-panel v-if="this.$store.state.showMenu"></menu-panel>
      </div>
      <i id="menu-btn" v-on:click="showHideMenu" class="fas fa-3x fa-bars"></i>
    </div>
    <div class="mobile-menu">
        <menu-panel v-if="this.$store.state.showMenu"></menu-panel>
    </div>

  </div>
</template>

<script>
import menuPanel from '@/components/MenuPanel.vue';

export default {
  components: { menuPanel },
  data() {
    return {
      showMenu: false,
    }
  },

  methods: {
    showHideMenu() {
      // this.showMenu = !this.showMenu;
      this.$store.commit('SET_SHOW_MENU');
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
  /* height: 200px; */
}

.desktop-menu {
  display: flex;
  flex-direction: row;
  align-items: center;
  /* font-size: 1.5rem; */
  text-decoration: none;
  justify-content: space-between;
}

.petpals-logo {
  height: 50px;
  width: auto;
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
  margin: 0; 
  padding: 0; 
  justify-content: flex-end;
  }

  /* li { 
  float: left;
  margin: 10px; 
  font-size: 220%;
  margin-right: 5px;
  padding-right: 50px;
  } */

#menu-btn {
  margin-right: 35px;
}

#banner {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  /* height: 62.5px; */
}

@media only screen and (max-width: 768px) {
  .desktop-menu {
    display: none;
  }
  .mobile-menu {
    display: flex;
    flex-direction: row;
    width: 100%;
    margin: auto;
    justify-content: flex-end;
  }
  .header {
    /* height: 100px; */
  }
  .menu {
    background-color: white;
    z-index: 99;
    text-align: center;
  }


}

@media only screen and (min-width: 768px) {
  .mobile-menu {
    display: none;
  }
}


</style>