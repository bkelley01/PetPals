<template>
  <div id="app">
  <div id="nav">
      <header-text></header-text>
  </div>
    <router-view />
  </div>
</template>

<script>
import headerText from "@/components/Header.vue"

export default {
  name: "app",
  components: {
    headerText

  }, 
  data() {
    return {
      showMenu: false
    }
  },
  created() {
    this.$store.commit('UPDATE_USER_LIST');
  }
}
</script>
