<template>
  <div class="playdate-card" v-bind:key="playdate.playdateId">
    <h3>{{ playdate.title }}</h3>
    <p>{{ playdate.location }}</p>
    <time id="date">{{formattedDate}}</time>
    <!-- <p>{{ playdate.date }}</p> -->
    <time id="start-time">{{formattedTime(playdate.startTime)}}</time>
    <!-- <p>{{ playdate.startTime }}</p> -->
    <time id="end-time">{{formattedTime(playdate.endTime)}}</time>
    <!-- <p>{{ playdate.endTime }}</p> -->
    <p>{{ playdate.host }}</p>
    <p @click="printAttendees()">Attendees: {{ playdate.numPetsAttending }}</p>
    <p>{{ playdate.petsAttending }}</p>
    
    
  </div>
</template>

<script>
export default {
  name: "playdate-card",
  props: ["playdate"],
  showAttendees: false,
  computed: {
    formattedDate() {
      let date = new Date( this.playdate.date);
      const options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric' };
      let formattedDate = date.toLocaleDateString('en-US', options);
      return formattedDate;
    }
  },
  methods: {
    formattedTime(time) {
      let timeAsDate = new Date(this.playdate.date + ' ' + time);
      const options = { hour12: true, hour: '2-digit', minute: '2-digit' };
      let formattedTime = timeAsDate.toLocaleTimeString('en-US', options);
      return formattedTime;
    },
    printAttendees() {
      console.log(this.showAttendees);
      return true;
    }
  }
};
</script>

<style>
.playdate-card {
  /* margin: 5px 0px 5px 0px; */
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  width: 80%;
  border: 2px solid #eecd22ff;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;

}
</style>