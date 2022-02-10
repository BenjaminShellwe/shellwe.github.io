<template>
    <div>
        <page-header title="企业招聘门户">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业招聘门户网页</div>
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
    name: 'Enterprise',
    components: {PageMain},
    data() {
        return {
            search: '',
            tableData:
                [
                    {
                        id: '202102101712',
                        salary: '7k',
                        position: '主管'
                    },
                    {
                        id: '202102101713',
                        salary: '1.2w',
                        position: '经理'
                    },
                    {
                        id: '202102101714',
                        salary: '4k',
                        position: '教辅员'
                    },
                    {
                        id: '2016-05-03',
                        salary: '2w',
                        position: '总负责'
                    }
                ]
        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>

