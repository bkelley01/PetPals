<template>
    <div class="menu">
        <ul>
            <li v-if="$store.state.token" class="menu-buttons" v-on:click="openProfilePage">Profile</li>
            <li v-if="$store.state.token" class="menu-buttons" v-on:click="showHideMenu"><router-link class="router-links" v-bind:to="{ name: 'playdates' }" >Playdates </router-link></li>
            <li class="menu-buttons" v-on:click="showHideMenu"><router-link class="router-links" v-bind:to="{ name: 'messages' }">Forum </router-link></li>
            <li v-if="$store.state.token" class="menu-item menu-buttons" v-on:click="showHideMenu"><router-link class="router-links" v-bind:to="{ name: 'logout' }" >Logout</router-link></li>
            <li v-if="$store.state.token == ''" class="menu-item menu-buttons" v-on:click="showHideMenu"><router-link class="router-links" v-bind:to="{ name: 'login' }" >Login</router-link></li>
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
        },
        openProfilePage() {
            this.showHideMenu();
            this.$router.push(`/profile/${this.$store.state.user.username}`);
        }
    
    },
}
</script>

<style>
li.menu-buttons { 
  float: left;
  margin: 10px; 
  /* position: relative; */
  font-size: 200%;
  /* margin-right: 5px; */
  margin-right: 50px;
  height: 30px;
  text-align: right;
}

li.menu-buttons:hover {
      text-decoration: underline;
      cursor: pointer;
}

.router-links {
    text-decoration: none;
    color: black;
}

@media screen and (max-width: 768px) {
  li.menu-buttons {
      text-decoration: underline;
  }
}

</style>