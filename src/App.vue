<script setup lang="ts">
import { onMounted } from 'vue'
import { storeToRefs } from 'pinia'
import { RouterLink, RouterView } from 'vue-router'
import { useDeliveryStore } from './store'
const store = useDeliveryStore()
const { approvedShare, offers, urgent } = storeToRefs(store)
onMounted(store.load)
</script>

<template><div class="shell"><aside><div class="brand">FundClarityEU<span>TRANSITION</span></div><nav><RouterLink to="/">Disclosure files</RouterLink><RouterLink to="/insights">Transition guidance</RouterLink></nav><div class="health"><i /> Java disclosure service connected</div></aside><main><header><div><span class="eyebrow">Prepare clearer sustainable investment product categories with fewer duplicative disclosures</span><h1>Sustainable Fund Disclosure Transition Desk</h1></div><button @click="store.addOffer">Add disclosure file</button></header><section class="summary"><article><small>Files approved</small><strong>{{ approvedShare }}%</strong><div class="bar"><span :style="{ width: `${approvedShare}%` }" /></div></article><article><small>Funds tracked</small><strong>{{ offers.length }}</strong><p>Shared compliance view</p></article><article><small>High-priority files</small><strong>{{ urgent }}</strong><p>Needs attention</p></article></section><RouterView /></main></div></template>
