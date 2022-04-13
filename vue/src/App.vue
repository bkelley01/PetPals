<template>
  <div id="app">
  <div id="nav">
      <!-- <img class="petpals-logo" src="@/images/petpals.png" /> -->
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
  }
}
</script>

