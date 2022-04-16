<template>
  <div id="main-div">
    <div id="container">
      <form id="schedule">
        <div id="start">
          <label>What time does this event start?</label>
          <select>
            <option value="choose" selected>Select Time</option>
            <option value="9am">9:00 A.M.</option>
            <option value="930am">9:30 A.M.</option>
            <option value="10am">10:00 A.M.</option>
            <option value="1030am">10:30 A.M.</option>
            <option value="11am">11:00 A.M.</option>
            <option value="1130am">11:30 A.M.</option>
            <option value="12pm">12:00 P.M.</option>
            <option value="1230pm">12:30 P.M.</option>
            <option value="1pm">1:00 P.M.</option>
            <option value="130pm">1:30 P.M.</option>
            <option value="2pm">2:00 P.M.</option>
            <option value="230pm">2:30 P.M.</option>
          </select> <br/>
        </div>
        <div id="end">
          <label>What time does this event end?</label>
          <select>
            <option value="choose" selected>Select Time</option>
            <option value="9am">9:00 A.M.</option>
            <option value="930am">9:30 A.M.</option>
            <option value="10am">10:00 A.M.</option>
            <option value="1030am">10:30 A.M.</option>
            <option value="11am">11:00 A.M.</option>
            <option value="1130am">11:30 A.M.</option>
            <option value="12pm">12:00 P.M.</option>
            <option value="1230pm">12:30 P.M.</option>
            <option value="1pm">1:00 P.M.</option>
            <option value="130pm">1:30 P.M.</option>
            <option value="2pm">2:00 P.M.</option>
            <option value="230pm">2:30 P.M.</option>
          </select> <br />
        </div>
        <div id="location">
          <label>What location will this event take place at?</label>
          <input type="text" />
        </div>
      </form>
    </div>
      
  </div>
</template>

<script>
export default {

}
</script>

<style>

#schedule {
  display: block;
  background-color: white;
  margin: auto;
  text-align: center;
  width: 40%;
  padding: 20px;
  padding-top: 50px;
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

</style>