<template>
  <div class="container">
    <h2>My Playdates</h2>
    <button @click="console.log('clicked')" v-show="fakeUser.username === this.$store.state.user.username" id="manage-playdates-btn">
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
        showManagePetsOptions: false
        
      }
    },
    methods: {
      clickingButton() {
        console.log('clicked');
      }
    },
    computed: {
      fakeUser() {
        return this.$store.state.fakeUsers.find( p => p.username == this.$route.params.username);
      },
    },

    created() {
      playdateService.getUserPlaydates(this.fakeUser.username).then(response => {
        this.userPlaydates = response.data;
      })
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