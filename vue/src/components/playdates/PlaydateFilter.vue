<template>
  <div id="main-find-playdates">
    <div id="find-playdates-main-div">
        <div id='find-playdates-filter-div'>
            <h2>Find Available Playdates</h2>
            <form id="playdate-filter-form">
                
                <label class="search-label">Title</label>
                <input
                type="text"
                id="playdate-title"
                class="playdate-search-field"
                v-model="userChoices.playdateTitle"
                required />

                <label class="search-label">Location</label>
                <select 
                class="playdate-search-field"
                v-model="userChoices.playdateLocation">
                    <option value="">All Locations</option>
                    <option 
                        v-for="(location, index) in this.$store.state.locationOptions"
                        :key="index"
                        :value="location.locationName"
                    > 
                    {{location.locationName}} ({{location.neighborhood}})
                    </option>              
                </select>

                <label class="search-label">Date</label>
                <input
                class="playdate-search-field"
                type="date" v-model="userChoices.playdateDate" />     
            </form>
        </div>

        <div id="playdate-results-div">    
            <playdate-card v-for="playdate in filteredPlaydates" :key="playdate.playdateId" :playdate="playdate" />
        </div>
    </div>
  </div>
</template>

<script>
import PlaydateCard from '../profile/PlaydateCard.vue';
import playdateService from '@/services/PlaydateService.js';

export default {
    name: "playdate-filter",
    components: {PlaydateCard},
    data() {
        return {
            userChoices: {
                playdateTitle: "",
                playdateLocation: "",
                playdateDate: ""
            },
            playdates: []
        }
    },

    created() {
        playdateService.getAllPlaydates().then(response => {
            this.playdates = response.data;
        });

    },

    computed: {
        filteredPlaydates() {
            let fp = this.playdates;
                // return this.playdates.filter(curPlaydate => {
                // // let titleFilter = this.$store.state.playdateFilter.playdateTitle;
                
                // if (this.userChoices.playdateTitle != "") {
                //     return true;
                // } else {
                //      return curPlaydate.playdateTitle.includes(this.userChoices.playdateTitle);
                // }

            if (this.userChoices.playdateTitle != "") {
                fp = fp.filter(curPlaydate => {
                    return curPlaydate.playdateTitle.toLowerCase().includes(this.userChoices.playdateTitle.toLowerCase());
                });
            }

            if (this.userChoices.playdateLocation != "") {
                fp = fp.filter(curPlaydate => {
                    return curPlaydate.playdateLocation === this.userChoices.playdateLocation;
                });
            }

            if (this.userChoices.playdateDate != "") {
                fp = fp.filter(curPlaydate => {
                    return curPlaydate.playdateDate === this.userChoices.playdateDate;
                });
            }

            return fp;
        }
    }
}
</script>

<style>
#find-playdates-filter-div {
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

.playdate-search-field {
    width: 250px;
    height: 38px;
    border-radius: 5px;
    font-size: 20px;
    border: 1px solid #d1d1d1;
}

#playdate-results-div {
    margin: auto;
    display: flex;
    flex-wrap: wrap;
}

#playdate-title {
    padding: 0px;
    padding-left: 10px;
    border: 1px solid #d1d1d1;
    height: 34px;
    align-items: center;
}

</style>