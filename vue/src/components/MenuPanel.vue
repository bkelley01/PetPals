<template>
    <div class="menu">
        <ul>
            <li class="menu-buttons">Profile</li>
            <li class="menu-buttons">Playdates</li>
            <li class="menu-buttons">Messages</li>
            <li v-if="$store.state.token != ''" class="menu-item menu-buttons"><router-link v-bind:to="{ name: 'logout' }" >Logout</router-link></li>
            <li v-if="$store.state.token == ''" class="menu-item menu-buttons"><router-link v-bind:to="{ name: 'login' }" >Login</router-link></li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'menu-panel'
}
</script>

<style>
li.menu-buttons { 
  float: left;
  margin: 10px; 
  /* position: relative; */
  font-size: 220%;
  margin-right: 5px;
  padding-right: 50px;
  }

</style>