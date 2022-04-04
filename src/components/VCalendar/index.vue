<template>
    <div>
        <FullCalendar slot="reference" :options="calendarOptions" />
        <el-dialog
            title="即将创建..."
            :visible.sync="pageDialogVisible"
            width="10%"
        >
            <span>请四选一 进行创建</span>
            <br>
            <br>
            <div>
                <span>目标</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-button type="success" icon="el-icon-s-flag" circle style="margin-bottom: 10px;" @click="pageDialogUniVisible=true" /><br>
                <span>提醒</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-button type="warning" icon="el-icon-thumb" circle style="margin-bottom: 10px;" @click="pageDialogSubVisible=true" /><br>
                <span>任务</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-button type="danger" icon="el-icon-finished" circle style="margin-bottom: 10px;" @click="pageDialogTerVisible=true" /><br>
                <span>活动</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-button type="primary" icon="el-icon-date" circle style="margin-bottom: 10px;" @click="pageDialogActivityVisible=true, optTitle='活动'" />
            </div>
        </el-dialog>
        <el-dialog
            title="创建一个目标"
            :visible.sync="pageDialogUniVisible"
            width="30%"
        >
            <div class="block">
                <span class="demonstration">目标内容</span>
                <el-carousel height="150px">
                    <el-carousel-item v-for="item in 4" :key="item">
                        <h3 class="small">{{ item }}</h3>
                    </el-carousel-item>
                </el-carousel>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="pageDialogUniVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm('pageDialogUniVisible')">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog
            title="提醒记得..."
            :visible.sync="pageDialogSubVisible"
            width="30%"
        >
            <span>请输提醒</span>&nbsp;&nbsp;
            <el-input
                v-model="pageInputContext"
                style="width: auto;"
                prefix-icon="el-icon-circle-plus-outline"
                placeholder="请输入提醒内容"
                size="medium"
            />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <el-switch
                v-model="pageSwitchValue"
                active-value="1"
                inactive-value="0"
                active-text="全天活动"
                inactive-text=""
                active-color="#13ce66"
                inactive-color="#778899"
                @change="handleSwitch(1)"
            />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <el-switch
                v-model="pageSwitchValueUni"
                active-value="1"
                inactive-value="0"
                active-text="重复提醒"
                inactive-text=""
                active-color="#13ce66"
                inactive-color="#778899"
                @change="handleSwitch(2)"
            />
            <div v-show="pageTimeShowUni" class="inLine">
                <span>选择时间</span>&nbsp;&nbsp;
                <el-date-picker
                    v-model="pageTimePickerValue"
                    type="dates"
                    :picker-options="pickerOptions"
                    range-separator="至"
                    start-placeholder="开始时间"
                    end-placeholder="结束时间"
                    placeholder="选择时间范围"
                    align="right"
                    size="medium"
                />
            </div>
            <div v-show="pageDivVisible" style="margin-top: 20px;">
                <el-checkbox v-model="checkAllWeek" :indeterminate="isIndeterminateWeek" @change="handleCheckAllWeek">每周选择重复</el-checkbox>
                <el-checkbox v-model="checkMonth">每月今日重复</el-checkbox> <el-checkbox v-model="checkYear">每年今日重复</el-checkbox>
                <el-checkbox-group v-show="pageCheckboxVisible" v-model="checkDates" size="mini" @change="handleCheckedDatesChange">
                    <el-checkbox-button v-for="date in dates" :key="date" :label="date">{{ date }}</el-checkbox-button>
                </el-checkbox-group>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="pageDialogSubVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm('pageDialogSubVisible')">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog
            title="添加任务..."
            :visible.sync="pageDialogTerVisible"
            width="15%"
        >
            <el-input
                v-model="pageInputContextUni"
                prefix-icon="el-icon-circle-plus-outline"
                placeholder="请输入任务内容"
                size="medium"
            />
            <span slot="footer" class="dialog-footer">
                <el-button @click="pageDialogTerVisible= false">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm('pageDialogTerVisible')">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog
            :title="'创建一个'+optTitle"
            width="30%"
            :visible.sync="pageDialogActivityVisible"
        >
            <el-form :model="form">
                <el-row>
                    <el-col :span="14">
                        <el-form-item :label="optTitle + '标题'" label-width="70px">
                            <el-input v-model="form.title" style="width: 220px;" auto-complete="off" :placeholder="'请输入'+optTitle+'名称'" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="10" style="margin-left: 20px; margin-top: 6px; width: 150px;">
                        <el-switch
                            v-model="pageSwitchValue"
                            active-value="1"
                            inactive-value="0"
                            active-text="全天"
                            inactive-text="精确"
                            active-color="#13ce66"
                            inactive-color="#0000FF"
                            @change="handleSwitch(0)"
                        />
                    </el-col>
                </el-row>
                <el-row>
                    <el-form-item label="选择时间" label-width="70px">
                        <el-date-picker
                            v-show="pageTimeShow"
                            v-model="pageTimePickerValue"
                            type="datetimerange"
                            :picker-options="pickerOptions"
                            range-separator="至"
                            start-placeholder="开始时间"
                            end-placeholder="结束时间"
                            placeholder="选择时间范围"
                            align="right"
                            size="medium"
                            style="width: 220px;"
                        />
                        <el-date-picker
                            v-show="pageDateShow"
                            v-model="pageDatePickerValue"
                            type="daterange"
                            :picker-options="pickerOptions"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期"
                            align="right"
                            size="medium"
                            style="width: 220px;"
                        />
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="选择人员" label-width="70px">
                        <el-select v-model="pageSelectValue" multiple placeholder="请选择参与人员" style="width: 220px;">
                            <el-option
                                v-for="item in pageSelectOptions"
                                :key="item.selectValue"
                                :label="item.selectLabel"
                                :value="item.selectValue"
                                size="medium"
                            />
                        </el-select>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item :label="optTitle+'内容'" label-width="70px">
                        <el-input
                            v-model="pageInputText"
                            type="textarea"
                            autosize
                            placeholder="请输入活动说明内容"
                            style="width: auto; min-width: 220px; margin-left: 4px;"
                        />
                    </el-form-item>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="pageDialogActivityVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm('pageDialogActivityVisible')">创建</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import '@fullcalendar/core/vdom' // solves problem with Vite
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'
import timeGridPlugin from '@fullcalendar/timegrid'
import { INITIAL_EVENTS, createEventId } from './event-utils'
import axios from 'axios'

const dateOptions = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
export default {
    name: 'VCalendar',
    components: {
        FullCalendar // make the <FullCalendar> tag available
    },
    data: function() {
        return {
            calendarOptions: {
                plugins: [
                    dayGridPlugin,
                    timeGridPlugin,
                    interactionPlugin // needed for dateClick
                ],
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                buttonText: {
                    today: '今天',
                    month: '月',
                    week: '周',
                    day: '日'
                },
                locale: 'zh-cn', // 设置语言
                weekNumberCalculation: 'ISO', // 周数
                initialView: 'dayGridMonth',
                initialEvents: INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
                editable: true,
                selectable: true,
                selectMirror: true,
                dayMaxEvents: true,
                weekends: true,
                select: this.handleDateCheck,
                eventClick: this.handleEventClick,
                eventsSet: this.handleEvents
                /* you can update a remote database when these fire:
                eventAdd:
                eventChange:
                eventRemove:
                */
            },
            eventTime: {
                hour: 'numeric',
                minute: '2-digit',
                hour12: false
            },
            calendarEvents: [],
            calendarEventDrop: info => {
                this.dropEvent(info)
            },
            handleDatesRender: arg => {
                this.getEventsList(arg.view)
            },

            dialogFormVisible: false,
            form: {
                title: null,
                start: null,
                end: null
            },
            optTitle: '',
            pickerOptions: {
                shortcuts: [{
                    text: '最近一周',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近一个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近三个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
                        picker.$emit('pick', [start, end])
                    }
                }]
            },
            pageSelectOptions: [{
                selectValue: 'Opt1',
                selectLabel: 'benjamin'
            }, {
                selectValue: 'Opt2',
                selectLabel: 'thomas'
            }, {
                selectValue: 'Opt3',
                selectLabel: 'shellwe'
            }, {
                selectValue: 'Opt4',
                selectLabel: 'yufeng'
            }, {
                selectValue: 'Opt5',
                selectLabel: 'admin'
            }],
            currentEvents: [],
            checkAllWeek: false,
            checkDates: [''],
            checkMonth: '',
            checkYear: '',
            dates: dateOptions,
            isIndeterminateWeek: true,
            outerVisible: false,
            pageCheckboxVisible: false,
            pageDialogVisible: false,
            pageDialogUniVisible: false,
            pageDialogSubVisible: false,
            pageDialogTerVisible: false,
            pageDialogActivityVisible: false,
            pageDivVisible: false,
            pageDateShow: false,
            pageTimeShow: true,
            pageTimeShowUni: true,
            pageDatePickerValue: '',
            pageInputTitle: '',
            pageInputContext: '',
            pageInputContextUni: '',
            pageInputText: '',
            pagePopoverVisible: false,
            pageSwitchValue: '1',
            pageSwitchValueUni: '0',
            pageSelectValue: '',
            pageTimePickerValue: ''
        }
    },
    watch: {

    },
    mounted() {

    },
    methods: {
        handleButtonConfirm(dialogvalue) {
            this.pageDialogVisible = false
            this[dialogvalue] = false
        },
        handleCheckAllWeek(val) {
            this.checkDates = val ? dateOptions : []
            this.isIndeterminateWeek = false
            this.pageCheckboxVisible = !this.isIndeterminateWeek

        },
        handleCheckedDatesChange(value) {
            let checkedCount = value.length
            this.checkAllWeek = checkedCount === this.dates.length
            this.isIndeterminateWeek = checkedCount > 0 && checkedCount < this.dates.length
        },
        handleClose(done) {
            this.$confirm('close?')
                .then(() => {
                    done()
                })
                .catch(() => {})
        },
        handleDateClick(arg) {
            this.dialogFormVisible = true
            this.optTitle = '新增事件'
            this.form.title = ''
            this.form.id = ''
            this.form.start = arg.date
            this.form.end = arg.date
        },
        handleDateCheck() {
            this.pageDialogVisible = true
        },
        handleDateSelect(selectInfo) {
            this.handleDateCheck()
            // let title = prompt('Please enter a new title for your event')
            let title = this.pageInputTitle
            let calendarApi = selectInfo.view.calendar
            calendarApi.unselect() // clear date selection

            if (title) {
                calendarApi.addEvent({
                    id: createEventId(),
                    title,
                    start: selectInfo.startStr,
                    end: selectInfo.endStr,
                    allDay: selectInfo.allDay
                })

            }
        },
        handleEventClick(clickInfo) {
            if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
                clickInfo.event.remove()
            }
            clickInfo.el.style.borderColor = 'red'
            this.dialogFormVisible = true
            this.optTitle = '修改事件'
            this.form = {
                id: clickInfo.event.id,
                title: clickInfo.event.title,
                start: clickInfo.event.start,
                end: clickInfo.event.end
            }
        },
        handleEvents(events) {
            this.currentEvents = events
        },
        getEventsList(info) {
            let params = {
                start: info.activeStart,
                end: info.activeEnd
            }
            axios({
                method: 'post',
                url: 'url',
                data: params
            }).then(res => {
                this.calendarEvents = res
            })
            console.log(info)
        },
        handleSwitch(val) {
            if (val == 0) {
                if (this.pageSwitchValue == 0) {
                    this.pageTimeShow = true
                    this.pageDateShow = false
                } if (this.pageSwitchValue == 1) {
                    this.pageTimeShow = false
                    this.pageDateShow = true
                }
            }
            if (val == 1) {
                if (this.pageSwitchValue == 0) {
                    this.pageTimeShowUni = false
                } if (this.pageSwitchValue == 1) {
                    this.pageTimeShowUni = true
                }
            }
            if (val == 2) {
                if (this.pageSwitchValueUni == 0) {
                    this.pageDivVisible = false
                } if (this.pageSwitchValueUni == 1) {
                    this.pageDivVisible = true
                }
            }

        },
        handleWeekendsToggle() {
            this.calendarOptions.weekends = !this.calendarOptions.weekends // update a property
        },
        // 保存事件
        saveEvent() {

        },
        // 删除事件
        delEvent() {

        },
        // 拖动事件
        dropEvent(info) {
            console.log(info)
        }
    }
}
</script>
<style>
.inLine {
    display: inline-block;
    margin-top: 10px;
    margin-bottom: 10px;
    margin-right: 10px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
}
.el-range-separator {
    width: 23px !important;
}
</style>

