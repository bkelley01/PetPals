<template>
  <div class="profile">
    <h1>{{fakeUser.username}}</h1>
    <p v-show="!fakeUser">User Not Found</p>
    <div v-if="fakeUser" class="cards-container">
      <!-- <username-card class="profile-cards" /> -->
      <my-pets class="profile-cards" />
      <my-playdates class="profile-cards" />
    </div>
  </div>
</template>

<script>
// import UsernameCard from '@/components/profile/UsernameCard.vue';
import MyPets from '@/components/profile/MyPets.vue';
import MyPlaydates from '@/components/profile/MyPlaydates.vue';
import userService from '@/services/UserService.js';

export default {
  name: "profile",
  components: {
    // UsernameCard,
    MyPets,
    MyPlaydates
  },
  data() {
    return {
      userList: [],
      fakeUser: {}
    }
  },
  computed: {
    // fakeUser() {
    //   if (this.userList) {
    //     return this.userList.find(
    //       (p) => p.username == this.$route.params.username
    //     );
    //   } else {
    //     return false;
    //   }
    // }
  },
  created() {
    this.$store.state.showManagePetsOption = false;
    userService.getAllUsers().then(r => {
      this.userList = r.data;
    }).then(() => {
      this.fakeUser = this.userList.find(p => {
      p.username === this.$route.params.username;
    })});

  },
  methods: {
    printUserList() {
      console.log(this.userList);
    }
  }
}
</script>

<style scoped>
  .profile {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .cards-container{
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .profile-cards{
    border-radius: 10px;
    text-align: center;
  }

</style>
