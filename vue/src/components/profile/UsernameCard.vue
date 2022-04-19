<template>
  <div class="container">
    <h2>{{user.username}}</h2>
    <p>{{user.username}}'s profile details</p>  
  </div>
</template>

<script>
import userService from '@/services/UserService.js'

export default {
    name: "username-card",
    data() {
      return {
        userList: []
      }
    },
    computed: {
      user() {
        return this.userList.find( p => p.username.toLowerCase() === this.$route.params.username.toLowerCase());
      }
    },
  created() {
    userService.getAllUsers().then(r => {
      this.userList = r.data;
    })
  }
}
</script>

<style scoped>
.container {
    width: 100%;
    /* border: 1px solid #eecd22ff; */
    background: white;
}
</style>