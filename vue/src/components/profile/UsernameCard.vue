<template>
  <div class="container">
    <h2>{{fakeUser.username}}</h2>
    <p>{{fakeUser.username}}'s profile details</p>  
  </div>
</template>

<script>
export default {
    name: "username-card",
    computed: {
      fakeUser() {
        return this.$store.state.fakeUsers.find( p => p.username == this.$route.params.username);
      }
    },
    created() {
      const username = this.$route.params.username;
      console.log(username);
    }
}
</script>

<style scoped>
.container {
    width: 80%;
    border: 1px solid red;
}
</style>