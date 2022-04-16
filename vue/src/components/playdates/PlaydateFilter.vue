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
            <option value="Summit Park">Summit Park (Blue Ash)</option>
            <option value="Washington Park">Washington Park (OTR)</option>
            <option value="Winton Woods">Winton Woods Park (Sharonville)</option>
            <option value="Fido Field">Fido Field (Downtown)</option>
            <option value="Eden Park">Eden Park (Mt. Adams)</option>              
        </select>

        <label>Date</label>
        <input type="date" v-model="userChoices.playdateDate" />

        <button @click="filterPlaydates()">Find Playdates</button>
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
        }
    },

    created() {
        playdateService.getAllPlaydates().then(response => {
            this.playdates = response.data;
        });
    },

    computed: {
        filteredPlaydates() {
           return this.playdates.filter(curPlaydate => {
                // let titleFilter = this.$store.state.playdateFilter.playdateTitle;
                
                if (this.userChoices.playdateTitle != "") {
                    return true;
                } else {
                     return curPlaydate.playdateTitle.includes(this.userChoices.playdateTitle);
                }

           }); 
        }
    }
}
</script>

<style>

</style>