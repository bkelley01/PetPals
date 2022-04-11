<template>
  <div class="header">
    <div class="logo">
      <img class="petpals-logo" src="@/images/petpals.png" />
      <div class="header-options">
        <router-link style="text-decoration: none" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link style="text-decoration: none" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >&nbsp;|&nbsp;Logout</router-link>
      </div>
    </div>
    <div class="menu">
      <div class="my-pets"></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap');

* {
  font-family: 'Montserrat', sans-serif;
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
  width: 25%;
}

.header-options {
  font-size: 1.5em;
}

router-link {
  text-decoration: none;
}


</style>