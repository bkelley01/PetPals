<template>
  <div id="main-div">
    <div id="container">
      <form id="schedule">
        <h2>Create Playdate</h2>
        <div id="title">
          <label>What is the name of your event?</label>
          <input
            type="text"
            id="title-text"
            v-model="newPlaydate.playdateTitle"
          />
        </div>
        <div id="date">
          <label>What day are you scheduling for?</label>
          <input type="date" id="date-input" v-model="newPlaydate.playdateDate" />
        </div>
        <div id="start">
          <label>What time does this event start?</label>
          <select id="start-time" v-model="newPlaydate.startTime">
            <option value="">Select Time</option>
            <option value="09:00:00">9:00 A.M.</option>
            <option value="09:30:00">9:30 A.M.</option>
            <option value="10:00:00">10:00 A.M.</option>
            <option value="10:30:00">10:30 A.M.</option>
            <option value="11:00:00">11:00 A.M.</option>
            <option value="11:30:00">11:30 A.M.</option>
            <option value="12:00:00">12:00 P.M.</option>
            <option value="12:30:00">12:30 P.M.</option>
            <option value="13:00:00">1:00 P.M.</option>
            <option value="13:30:00">1:30 P.M.</option>
            <option value="14:00:00">2:00 P.M.</option>
            <option value="14:30:00">2:30 P.M.</option>
          </select>
          <br />
        </div>
        <div id="end">
          <label>What time does this event end?</label>
          <select id="end-time" v-model="newPlaydate.endTime">
            <option value="">Select Time</option>
            <option value="09:00:00">9:00 A.M.</option>
            <option value="09:30:00">9:30 A.M.</option>
            <option value="10:00:00">10:00 A.M.</option>
            <option value="10:30:00">10:30 A.M.</option>
            <option value="11:00:00">11:00 A.M.</option>
            <option value="11:30:00">11:30 A.M.</option>
            <option value="12:00:00">12:00 P.M.</option>
            <option value="12:30:00">12:30 P.M.</option>
            <option value="13:00:00">1:00 P.M.</option>
            <option value="13:30:00">1:30 P.M.</option>
            <option value="14:00:00">2:00 P.M.</option>
            <option value="14:30:00">2:30 P.M.</option>
          </select>
          <br />
        </div>
        <div id="location">
          <label>What location will this event take place at?</label>
          <select
            id="location-text"
            v-model="newPlaydate.playdateLocation"
          >
            <option value=""></option>
            <option 
                v-for="(location, index) in this.$store.state.locationOptions"
                :key="index"
                :value="location.locationName"
            > 
            {{location.locationName}} ({{location.neighborhood}})
            </option>  
          </select>
        </div>
        <div>
          <button
            class="btn btn-lg btn-primary btn-block"
            id="create-playdate-btn"
            @click="createPlaydate()"
          >
            Create Playdate
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import playdateService from "@/services/PlaydateService.js";

export default {
  name: "create-playdate",
  data() {
    return {
      newPlaydate: {
        playdateTitle: "",
        playdateLocation: "",
        playdateDate: "",
        startTime: "",
        endTime: ""
      },
      registrationErrorMsg: "",
    };
  },
  methods: {
    createPlaydate() {
      playdateService
        .createPlaydate(this.newPlaydate)
        .then((r) => {
          if (r.status === 201) {
            alert(`Successfully created ${this.newPlaydate.playdateTitle}`);
            this.newPlaydate = {
              playdateTitle: "",
              playdateLocation: "",
              playdateDate: "",
              startTime: "",
              endTime: "",
            };
            // this.$router.push('/playdates');
          }
        })
        .catch((e) => this.handleErrorResponse(e));
    },
    handleErrorResponse(error) {
      if (error) {
        alert("Unable to add pet. Please try again...");
      }
    },
  },
};
</script>

<style>
#schedule {
  display: block;
  background-color: white;
  margin: auto;
  text-align: center;
  width: 40%;
  padding: 20px;
  padding-top: 20px;
  padding-bottom: 50px;
  border-radius: 20px;
}

#start {
  padding: 40px;
}

#end {
  padding: 40px;
}

#location {
  padding: 40px;
}

#start-time {
  margin: 10px;
  width: 40%;
}

#end-time {
  margin: 10px;
  width: 40%;
}

#location-text {
  margin: 10px;
  width: 40%;
}

#date-input {
  margin: 10px;
  width: 40%;
}

#title-text {
  margin: 10px;
  width: 40%;
}

@media only screen and (max-width: 450px) {
  #start-time {
    margin: 10px;
    width: 80%;
  }

  #end-time {
    margin: 10px;
    width: 80%;
  }

  #location-text {
    margin: 10px;
    width: 80%;
  }

  #schedule {
    display: block;
    background-color: white;
    margin: auto;
    text-align: center;
    width: 80%;
    padding: 20px;
    padding-top: 20px;
    padding-bottom: 50px;
    border-radius: 20px;
  }
}
</style>