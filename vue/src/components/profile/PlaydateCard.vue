<template>
  <div class="playdate-card" v-bind:key="playdate.playdateId">
    <h3>{{ playdate.title }}</h3>
    <p id="location"><i class="fas fa-map-marker-alt"></i> {{ playdate.location }}</p>
    <p id="date">
      <time><i class="far fa-calendar-alt"></i> {{ formattedDate }}</time>
    </p>
    <p id="times-together">
      <i class="far fa-clock"></i>
      <time id="start-time"> {{ formattedTime(playdate.startTime) }}</time>
      -
      <time id="end-time">{{ formattedTime(playdate.endTime) }}</time>
    </p>
    <!-- <p>{{ playdate.date }}</p> -->

    <!-- <p>{{ playdate.startTime }}</p> -->

    <!-- <p>{{ playdate.endTime }}</p> -->

    <p id="host"><i class="far fa-user"></i> {{ playdate.host }}</p>
    <p id="attendees-link" @click="showAttendees = !showAttendees">
      Attendees: {{ playdate.attendees.length }}
    </p>
    <ul v-if="showAttendees">
      <li
        class="pets-attending"
        v-for="(pet, index) in playdate.attendees"
        :key="index"
      >
        {{ pet }}
      </li>
    </ul>
    <!-- <p>{{ playdate.petsAttending }}</p> -->
  </div>
</template>

<script>
export default {
  name: "playdate-card",
  props: ["playdate"],
  data() {
    return {
      showAttendees: false,
    };
  },
  computed: {
    formattedDate() {
      let date = new Date(this.playdate.date);
      const options = {
        weekday: "short",
        year: "numeric",
        month: "short",
        day: "numeric",
      };
      let formattedDate = date.toLocaleDateString("en-US", options);
      return formattedDate;
    },
  },
  methods: {
    formattedTime(time) {
      let timeAsDate = new Date(this.playdate.date + " " + time);
      const options = { hour12: true, hour: "2-digit", minute: "2-digit" };
      let formattedTime = timeAsDate.toLocaleTimeString("en-US", options);
      return formattedTime;
    },
  },
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

#location {
  margin: 16px 0px 8px 0px;
}

#date {
  margin: 8px 0px 8px 0px;
}

#times-together {
  margin: 8px 0px 8px 0px;
}

#host {
  margin: 8px 0px 8px 0px;
}

#attendees-link {
  margin: 8px 0px 8px 0px;
  text-decoration: underline;
}
#attendees-link:hover {
  cursor: pointer;
}

.pets-attending {
  list-style-type: none;
  width: 100%;
}

i {
  height: 20px;
  width: 20px;
}

@media screen and (min-width: 768px) {
  .playdate-card {
    width: 300px;
    /* margin: 5px; */
  }
}
</style>