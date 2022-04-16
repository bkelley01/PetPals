<template>
  <div class="main">
    <form>
        <label>Title</label>
        <input
        type="text"
        id="playdate-title"
        class="input-fields"
        v-model="userChoices.playdateTitle"
        required />

        <label>Location</label>
        <select v-model="userChoices.playdateLocation">
            <option value="">All Locations</option>
            <option value="Summit Park">Summit Park (Blue Ash)</option>
            <option value="Washington Park">Washington Park (OTR)</option>
            <option value="Winton Woods">Winton Woods Park (Sharonville)</option>
            <option value="Fido Field">Fido Field (Downtown)</option>
            <option value="Eden Park">Eden Park (Mt. Adams)</option>              
        </select>

        <label>Date</label>
        <input type="date" v-model="userChoices.playdateDate" />
         
        <button @click="logDates()">Find Playdates</button>
    </form>
    
    <playdate-card v-for="playdate in filteredPlaydates" :key="playdate.playdateId" :playdate="playdate" />
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

    methods: {
        filterPlaydates() {
            this.$store.commit('FILTER_PLAYDATES', this.userChoices);
            this.$router.go();
            this.userChoices = {playdateTitle: "",  playdateLocation: "", playdateDate: ""}
        },

        logDates() {
            console.log('Date in filter is' + this.userChoices.playdateDate);
            console.log('date in database is' + this.playdates[0].playdateDate);
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
                    return curPlaydate.playdateTitle.includes(this.userChoices.playdateTitle);
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

</style>