<template>
  <div id="main-div">
    <div id="container">
      <form id="schedule">
        <h2>Create Playdate</h2>
        <div id="title">
          <label>What is the name of your event?</label><br />
          <input
            type="text"
            id="title-text"
            class="inputs"
            placeholder="Enter Title"
            v-model="newPlaydate.playdateTitle"
          />
        </div>
        <div id="date-create">
          <label>What day are you scheduling for?</label> <br />
          <input
            type="date"
            id="date-input"
            class="inputs"
            v-model="newPlaydate.playdateDate"
          />
        </div>
        <div id="start">
          <label>What time does this event start?</label><br />
          <select
            id="start-time"
            class="inputs"
            v-model="newPlaydate.startTime"
          >
            <!-- TODO look into time input on thursday and add more times -->
            <option value="">Select Time</option>
            <option value="07:00:00">7:00 A.M.</option>
            <option value="07:30:00">7:30 A.M.</option>
            <option value="08:00:00">8:00 A.M.</option>
            <option value="08:30:00">8:30 A.M.</option>
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
            <option value="15:00:00">3:00 P.M.</option>
            <option value="15:30:00">3:30 P.M.</option>
            <option value="16:00:00">4:00 P.M.</option>
            <option value="16:30:00">4:30 P.M.</option>
            <option value="17:00:00">5:00 P.M.</option>
            <option value="17:30:00">5:30 P.M.</option>
            <option value="18:00:00">6:00 P.M.</option>
            <option value="18:30:00">6:30 P.M.</option>
            <option value="19:00:00">7:00 P.M.</option>
            <option value="19:30:00">7:30 P.M.</option>
            <option value="20:00:00">8:00 P.M.</option> 
          </select>
          <br />
        </div>
        <div id="end">
          <label>What time does this event end?</label><br />
          <select id="end-time" class="inputs" v-model="newPlaydate.endTime">
            <option value="">Select Time</option>
            <option value="07:30:00">7:30 A.M.</option>
            <option value="08:00:00">8:00 A.M.</option>
            <option value="08:30:00">8:30 A.M.</option>
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
            <option value="15:00:00">3:00 P.M.</option>
            <option value="15:30:00">3:30 P.M.</option>
            <option value="16:00:00">4:00 P.M.</option>
            <option value="16:30:00">4:30 P.M.</option>
            <option value="17:00:00">5:00 P.M.</option>
            <option value="17:30:00">5:30 P.M.</option>
            <option value="18:00:00">6:00 P.M.</option>
            <option value="18:30:00">6:30 P.M.</option>
            <option value="19:00:00">7:00 P.M.</option>
            <option value="19:30:00">7:30 P.M.</option>
            <option value="20:00:00">8:00 P.M.</option>
            <option value="20:30:00">8:30 P.M.</option>
          </select>
          <br />
        </div>
        <div id="location">
          <label>What location will this event take place at?</label><br />
          <select
            id="location-text"
            class="inputs"
            v-model="newPlaydate.playdateLocation"
          >
            <option value="">Select Location</option>
            <option
              v-for="(location, index) in this.$store.state.locationOptions"
              :key="index"
              :value="location.locationName"
            >
              {{ location.locationName }} ({{ location.neighborhood }})
            </option>
          </select>
        </div>
        <div>
          <button
            class="btn btn-lg btn-primary btn-block"
            id="create-playdate-btn"
            @click.prevent="createPlaydate()"
          >
            Create Playdate
          </button>
        </div>
      </form>
      <img id="ball" src="@/images/ball.gif" />
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
        endTime: "",
      },
      registrationErrorMsg: "",
    };
  },

  //

  /*
  Things to validate for playdate:
    - No fields are empty (can be done with required keyword w/in form)
    - Date is today or in the future
    - End time is after start time
  */
  methods: {
    createPlaydate() {
      
      if (this.isValidPlaydate()) {

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
            this.$router.push('/playdates');
          } 
          
        })
        .catch((e) => this.handleErrorResponse(e));

      } else {
        alert('Please enter a valid playdate');
      }
        
    },

    isValidPlaydate() {
      if (this.hasAnyEmptyFields()) {
        return false;
      } else if (!this.isValidDate()) {
        return false;
      } else if (!this.endTimeAfterStartTime()) {
        return false;
      }


      return true;

    },

    isValidDate() {
      let unixDate = new Date(Date.now()) ;
      let curDate = new Date(unixDate.toLocaleDateString());

      let pdDate = new Date(this.newPlaydate.playdateDate);

      pdDate.setDate(pdDate.getDate() + 1);
      const options = {
        weekday: "short",
        year: "numeric",
        month: "short",
        day: "numeric",
      };
      let formattedDate = pdDate.toLocaleDateString("en-US", options);
      let pdDateString = new Date(formattedDate);
      
      return pdDateString.getTime() >= curDate.getTime();
    },

    hasAnyEmptyFields() {
      return !this.newPlaydate.playdateTitle || !this.newPlaydate.playdateLocation || !this.newPlaydate.playdateDate ||
        !this.newPlaydate.startTime || !this.newPlaydate.endTime;
    },

    endTimeAfterStartTime() {
      return this.newPlaydate.endTime > this.newPlaydate.startTime;
    },

    handleErrorResponse(error) {
      if (error) {
        alert("Please answer all fields");
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
  width: 25%;
  padding-top: 20px;
  padding-bottom: 50px;
  border-radius: 20px;
  font-size: 16px;
}

#title {
  padding: 20px;
}

#date-create {
  padding: 20px;
}

#start {
  padding: 20px;
}

#end {
  padding: 20px;
}

#location {
  padding: 20px;
}

#start-time {
  margin: 10px;
  width: 70%;
}

#end-time {
  margin: 10px;
  width: 70%;
}

#location-text {
  margin: 10px;
  width: 70%;
}

#title-text {
  margin: 10px;
  width: 70%;
}

#date-input {
  margin: 10px;
  width: 70%;
}

#title-text {
  margin: 10px;
  width: 68%;
}

#ball {
  display: block;
  position: fixed;
  top: 50%;
  left: 62.5%;
  height: 300px;
  width: auto;
}

#create-playdate-btn {
  grid-area: sign-up-button;
  margin-top: 5%;
  background-color: #42b72a;
  border-radius: 5px;
  height: 40px;
  width: 250px;
  margin-left: auto;
  margin-right: auto;
  border: none;
  color: white;
  font-size: 16px;
  cursor: pointer;
}

.inputs {
  border-radius: 5px;
  border: 1px solid #d1d1d1;
  height: 38px;
}

@media only screen and (max-width: 1200px) {
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
    /* display: block;
    background-color: white;
    margin: auto;
    text-align: center; */
    width: 300px;
    /* padding: 20px;
    padding-top: 20px;
    padding-bottom: 50px;
    border-radius: 20px; */
  }
}
</style>