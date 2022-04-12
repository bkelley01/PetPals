<template>
  <div class="playdate-card" v-bind:key="playdate.playdateId">
    <h3>{{ playdate.title }}</h3>
    <p>{{ playdate.location }}</p>
    <p>{{ playdate.date }}</p>
    <p>{{ playdate.startTime }}</p>
    <p>{{ playdate.endTime }}</p>
    <p>{{ playdate.host }}</p>
    <p>{{ playdate.numPetsAttending }}</p>
    <p>{{ playdate.petsAttending }}</p>
  </div>
</template>

<script>
export default {
  name: "playdate-card",
  props: ["playdate"],
  computed: {
    parseDate() {
      return true;
    },
  },
};
</script>

<style>
</style>