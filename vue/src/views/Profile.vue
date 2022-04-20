<template>
  <div class="profile">
    <h1>{{compUser.username}}</h1>
    <p v-show="!compUser">User Not Found</p>
    <div v-if="compUser" class="cards-container">
      <my-pets class="profile-cards" />
      <my-playdates class="profile-cards" />
    </div>
  </div>
</template>

<script>
import MyPets from '@/components/profile/MyPets.vue';
import MyPlaydates from '@/components/profile/MyPlaydates.vue';

export default {
  name: "profile",
  components: {
    MyPets,
    MyPlaydates
  },
  data() {
    return {
      userList: [],
    }
  },
  computed: {
    compUser() {
      return this.userList.find( p => p.username.toLowerCase() == this.$route.params.username.toLowerCase());
    },

  },
  created() {
    this.$store.state.showManagePetsOption = false;
    this.userList = this.$store.state.userList;
    console.log(this.userList);
    console.log(this.$store.state.userList);
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
