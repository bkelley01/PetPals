<template>
  <div class="container">
    <h2>My Playdates</h2>
    <p>List of Playdates</p>
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
        console.log(this.fakeUser.playdates);
        // let playdates = this.fakeUser.playdates.filter( () => {
        //   //this.$store.state.playdates.includes(playdate.playdateId);
          
        // });
        let playdates = this.$store.state.playdates.filter((playdate) => {
          return this.fakeUser.playdates.includes(playdate.playdateId);
        });
        console.log(playdates);
        console.log('hello world');
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
</style>