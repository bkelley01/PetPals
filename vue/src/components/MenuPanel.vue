<template>
    <div class="menu">
        <ul>
            <li class="menu-buttons" v-on:click="showHideMenu">Profile</li>
            <li class="menu-buttons" v-on:click="showHideMenu">Playdates</li>
            <li class="menu-buttons" v-on:click="showHideMenu">Messages</li>
            <li v-if="$store.state.token != ''" class="menu-item menu-buttons" v-on:click="showHideMenu"><router-link v-bind:to="{ name: 'logout' }" >Logout</router-link></li>
            <li v-if="$store.state.token == ''" class="menu-item menu-buttons" v-on:click="showHideMenu"><router-link v-bind:to="{ name: 'login' }" >Login</router-link></li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'menu-panel',
    methods: {
      showHideMenu() {
        // this.showMenu = !this.showMenu;
        this.$store.commit('SET_SHOW_MENU');
    }
  }
}
</script>

<style>
li.menu-buttons { 
  float: left;
  margin: 10px; 
  /* position: relative; */
  font-size: 200%;
  margin-right: 5px;
  padding-right: 50px;
  height: 50px;
  text-align: right;
  }

</style>