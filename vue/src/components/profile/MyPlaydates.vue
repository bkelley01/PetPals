<template>
  <div class="container">
    <h2>My Playdates</h2>
    <button v-show="compUser.username === this.$store.state.user.username" v-on:click="goToPlaydates()" id="manage-playdates-btn">
      Manage Playdates
    </button>
    <div id="playdate-card-container">
      <playdate-card v-for="playdate in userPlaydates" :key="playdate.playdateId" v-bind:playdate="playdate"/>
    </div>
      
  </div>
</template>

<script>
import PlaydateCard from '@/components/profile/PlaydateCard.vue';
import playdateService from '@/services/PlaydateService.js';

export default {
    name: "my-playdates",
    components: {PlaydateCard},
    data() {
      return {
        userPlaydates: [],
        showManagePetsOptions: false,
        userList: []
      }
    },
    methods: {
      goToPlaydates() {
        this.$router.push('/playdates');
      }
    },
    
    computed: {
      compUser() {
        return this.userList.find( p => p.username.toLowerCase() == this.$route.params.username.toLowerCase());
      },
    },

    created() {
      playdateService.getUserPlaydates(this.$route.params.username).then(response => {
        this.userPlaydates = response.data;
      });
      this.userList = this.$store.state.userList;
    }
}
</script>

<style scoped>
.container {
  width: 100%;
  /* border: 1px solid #eecd22ff; */
  background: white;
  margin-top: 15px;
}

button {
  cursor: pointer;
}

#manage-playdates-btn {
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  background-color: #3399FF;
  color: white;
  margin-bottom: 10px;
}

@media screen and (min-width: 768px) {
  #playdate-card-container {
    /* width: 300px; */
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    width: 100%;
    flex-wrap: wrap;
  }
}
</style>