<template>
  <div class="container">
    <h2>My Playdates</h2>
    <button v-show="fakeUser.username === this.$store.state.user.username " id="manage-playdates-btn">
      Manage Playdates
    </button>
    <playdate-card v-for="playdate in userPlaydates()" :key="playdate.playdateId" v-bind:playdate="playdate"/>
      
  </div>
</template>

<script>
import PlaydateCard from '@/components/profile/PlaydateCard.vue';
export default {
    name: "my-playdates",
    components: {PlaydateCard},
    computed: {
      fakeUser() {
        return this.$store.state.fakeUsers.find( p => p.username == this.$route.params.username);
      },
      // userPlaydates() {
      //   return this.fakeUser.playdates
      // }
    },
    methods: {
      userPlaydates() {
        let playdates = this.$store.state.playdates.filter((playdate) => {
          return this.fakeUser.playdates.includes(playdate.playdateId);
        });
        return playdates;
      }
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

</style>