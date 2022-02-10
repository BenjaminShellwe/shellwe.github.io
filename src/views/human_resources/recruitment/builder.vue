<template>
    <div>
        <page-header title="简历生成工具">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面为简历生成工具</div>
                </div>
            </template>
        </page-header>
        <page-main>
            单独设计
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Builder',
    components: {PageMain},
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>

