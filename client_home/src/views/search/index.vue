<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>



						  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_student_id"
				title="普通用户学号"
				source_table="ordinary_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_full_name"
				title="普通用户姓名"
				source_table="ordinary_users"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/general_manager/list', 'get')"
				:list="result_general_manager_student_id"
				title="普通管理者学号"
				source_table="general_manager"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/general_manager/list', 'get')"
				:list="result_general_manager_manager_name"
				title="普通管理者管理者姓名"
				source_table="general_manager"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/site_announcement/list', 'get')"
				:list="result_site_announcement_announcement_title"
				title="站点公告公告标题"
				source_table="site_announcement"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/site_announcement/list', 'get')"
				:list="result_site_announcement_release_time"
				title="站点公告发布时间"
				source_table="site_announcement"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/party_building_information/list', 'get')"
				:list="result_party_building_information_information_title"
				title="党建资讯资讯标题"
				source_table="party_building_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_building_information/list', 'get')"
				:list="result_party_building_information_information_type"
				title="党建资讯资讯类型"
				source_table="party_building_information"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/party_building_activities/list', 'get')"
				:list="result_party_building_activities_activity_name"
				title="党建活动活动名称"
				source_table="party_building_activities"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_building_activities/list', 'get')"
				:list="result_party_building_activities_activity_type"
				title="党建活动活动类型"
				source_table="party_building_activities"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/party_building_notice/list', 'get')"
				:list="result_party_building_notice_notification_title"
				title="党建通知通知标题"
				source_table="party_building_notice"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_building_notice/list', 'get')"
				:list="result_party_building_notice_notification_type"
				title="党建通知通知类型"
				source_table="party_building_notice"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/experience/list', 'get')"
				:list="result_experience_full_name"
				title="心得体会姓名"
				source_table="experience"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/thought/list', 'get')"
				:list="result_thought_full_name"
				title="思想汇报姓名"
				source_table="thought"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/party_dues_payment/list', 'get')"
				:list="result_party_dues_payment_date"
				title="党费缴交日期"
				source_table="party_dues_payment"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/party_lesson_information/list', 'get')"
				:list="result_party_lesson_information_party_lesson_theme"
				title="党课信息党课主题"
				source_table="party_lesson_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_lesson_information/list', 'get')"
				:list="result_party_lesson_information_type_of_party_courses"
				title="党课信息党课类型"
				source_table="party_lesson_information"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/sign_in_information/list', 'get')"
				:list="result_sign_in_information_party_lesson_theme"
				title="签到信息党课主题"
				source_table="sign_in_information"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/sign_in_information/list', 'get')"
				:list="result_sign_in_information_party_class_date"
				title="签到信息党课日期"
				source_table="sign_in_information"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/leave_information/list', 'get')"
				:list="result_leave_information_party_lesson_theme"
				title="请假信息党课主题"
				source_table="leave_information"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/department_category/list', 'get')"
				:list="result_department_category_department_category"
				title="院系类别院系类别"
				source_table="department_category"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/party_member_information/list', 'get')"
				:list="result_party_member_information_student_id"
				title="党员信息学号"
				source_table="party_member_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_member_information/list', 'get')"
				:list="result_party_member_information_full_name"
				title="党员信息姓名"
				source_table="party_member_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/party_member_information/list', 'get')"
				:list="result_party_member_information_identity"
				title="党员信息身份"
				source_table="party_member_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/party_member_information/list', 'get')"
				:list="result_party_member_information_hospital"
				title="党员信息院别"
				source_table="party_member_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/party_member_information/list', 'get')"
				:list="result_party_member_information_number_of_active_members_of_the_party"
				title="党员信息入党积极分子期数"
				source_table="party_member_information"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/certificate_of_achievement/list', 'get')"
				:list="result_certificate_of_achievement_full_name"
				title="成绩证书姓名"
				source_table="certificate_of_achievement"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/suggested_feedback/list', 'get')"
				:list="result_suggested_feedback_full_name"
				title="建议反馈姓名"
				source_table="suggested_feedback"
			  ></list_result_search>
															</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
						"result_ordinary_users_student_id":[],
								"result_ordinary_users_full_name":[],
																		"result_general_manager_student_id":[],
								"result_general_manager_manager_name":[],
																		"result_site_announcement_announcement_title":[],
								"result_site_announcement_release_time":[],
																					"result_party_building_information_information_title":[],
								"result_party_building_information_information_type":[],
																								"result_party_building_activities_activity_name":[],
								"result_party_building_activities_activity_type":[],
																											"result_party_building_notice_notification_title":[],
								"result_party_building_notice_notification_type":[],
																											"result_experience_full_name":[],
																					"result_thought_full_name":[],
																					"result_party_dues_payment_date":[],
															"result_party_lesson_information_party_lesson_theme":[],
								"result_party_lesson_information_type_of_party_courses":[],
																											"result_sign_in_information_party_lesson_theme":[],
											"result_sign_in_information_party_class_date":[],
																					"result_leave_information_party_lesson_theme":[],
															"result_department_category_department_category":[],
									"result_party_member_information_student_id":[],
								"result_party_member_information_full_name":[],
														"result_party_member_information_identity":[],
								"result_party_member_information_hospital":[],
														"result_party_member_information_number_of_active_members_of_the_party":[],
																		"result_certificate_of_achievement_full_name":[],
																											"result_suggested_feedback_full_name":[],
													};
  },
  methods: {

				/**
	 * 获取student_id
	 */
	get_ordinary_users_student_id(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "student_id": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_student_id = json.result.list;
			result_ordinary_users_student_id.map(o => o.title = o['student_id'])
	  			this.result_ordinary_users_student_id = result_ordinary_users_student_id
		 	}
		});
	},
						/**
	 * 获取full_name
	 */
	get_ordinary_users_full_name(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_full_name = json.result.list;
			result_ordinary_users_full_name.map(o => o.title = o['full_name'])
	  			this.result_ordinary_users_full_name = result_ordinary_users_full_name
		 	}
		});
	},
																/**
	 * 获取student_id
	 */
	get_general_manager_student_id(){
		this.$get("~/api/general_manager/get_list?like=0", { page: 1, size: 10, "student_id": this.query.word }, (json) => {
		  if (json.result) {
			var result_general_manager_student_id = json.result.list;
			result_general_manager_student_id.map(o => o.title = o['student_id'])
	  			this.result_general_manager_student_id = result_general_manager_student_id
		 	}
		});
	},
						/**
	 * 获取manager_name
	 */
	get_general_manager_manager_name(){
		this.$get("~/api/general_manager/get_list?like=0", { page: 1, size: 10, "manager_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_general_manager_manager_name = json.result.list;
			result_general_manager_manager_name.map(o => o.title = o['manager_name'])
	  			this.result_general_manager_manager_name = result_general_manager_manager_name
		 	}
		});
	},
																/**
	 * 获取announcement_title
	 */
	get_site_announcement_announcement_title(){
		this.$get("~/api/site_announcement/get_list?like=0", { page: 1, size: 10, "announcement_title": this.query.word }, (json) => {
		  if (json.result) {
			var result_site_announcement_announcement_title = json.result.list;
			result_site_announcement_announcement_title.map(o => o.title = o['announcement_title'])
	  			this.result_site_announcement_announcement_title = result_site_announcement_announcement_title
		 	}
		});
	},
						/**
	 * 获取release_time
	 */
	get_site_announcement_release_time(){
		this.$get("~/api/site_announcement/get_list?like=0", { page: 1, size: 10, "release_time": this.query.word }, (json) => {
		  if (json.result) {
			var result_site_announcement_release_time = json.result.list;
			result_site_announcement_release_time.map(o => o.title = o['release_time'])
	  			this.result_site_announcement_release_time = result_site_announcement_release_time
		 	}
		});
	},
																			/**
	 * 获取information_title
	 */
	get_party_building_information_information_title(){
		this.$get("~/api/party_building_information/get_list?like=0", { page: 1, size: 10, "information_title": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_information_information_title = json.result.list;
			result_party_building_information_information_title.map(o => o.title = o['information_title'])
	  			this.result_party_building_information_information_title = result_party_building_information_information_title
		 	}
		});
	},
						/**
	 * 获取information_type
	 */
	get_party_building_information_information_type(){
		this.$get("~/api/party_building_information/get_list?like=0", { page: 1, size: 10, "information_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_information_information_type = json.result.list;
			result_party_building_information_information_type.map(o => o.title = o['information_type'])
	  			this.result_party_building_information_information_type = result_party_building_information_information_type
		 	}
		});
	},
																						/**
	 * 获取activity_name
	 */
	get_party_building_activities_activity_name(){
		this.$get("~/api/party_building_activities/get_list?like=0", { page: 1, size: 10, "activity_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_activities_activity_name = json.result.list;
			result_party_building_activities_activity_name.map(o => o.title = o['activity_name'])
	  			this.result_party_building_activities_activity_name = result_party_building_activities_activity_name
		 	}
		});
	},
						/**
	 * 获取activity_type
	 */
	get_party_building_activities_activity_type(){
		this.$get("~/api/party_building_activities/get_list?like=0", { page: 1, size: 10, "activity_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_activities_activity_type = json.result.list;
			result_party_building_activities_activity_type.map(o => o.title = o['activity_type'])
	  			this.result_party_building_activities_activity_type = result_party_building_activities_activity_type
		 	}
		});
	},
																									/**
	 * 获取notification_title
	 */
	get_party_building_notice_notification_title(){
		this.$get("~/api/party_building_notice/get_list?like=0", { page: 1, size: 10, "notification_title": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_notice_notification_title = json.result.list;
			result_party_building_notice_notification_title.map(o => o.title = o['notification_title'])
	  			this.result_party_building_notice_notification_title = result_party_building_notice_notification_title
		 	}
		});
	},
						/**
	 * 获取notification_type
	 */
	get_party_building_notice_notification_type(){
		this.$get("~/api/party_building_notice/get_list?like=0", { page: 1, size: 10, "notification_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_building_notice_notification_type = json.result.list;
			result_party_building_notice_notification_type.map(o => o.title = o['notification_type'])
	  			this.result_party_building_notice_notification_type = result_party_building_notice_notification_type
		 	}
		});
	},
																									/**
	 * 获取full_name
	 */
	get_experience_full_name(){
		this.$get("~/api/experience/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_experience_full_name = json.result.list;
			result_experience_full_name.map(o => o.title = o['full_name'])
	  			this.result_experience_full_name = result_experience_full_name
		 	}
		});
	},
																			/**
	 * 获取full_name
	 */
	get_thought_full_name(){
		this.$get("~/api/thought/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_thought_full_name = json.result.list;
			result_thought_full_name.map(o => o.title = o['full_name'])
	  			this.result_thought_full_name = result_thought_full_name
		 	}
		});
	},
																			/**
	 * 获取date
	 */
	get_party_dues_payment_date(){
		this.$get("~/api/party_dues_payment/get_list?like=0", { page: 1, size: 10, "date": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_dues_payment_date = json.result.list;
			result_party_dues_payment_date.map(o => o.title = o['date'])
	  			this.result_party_dues_payment_date = result_party_dues_payment_date
		 	}
		});
	},
													/**
	 * 获取party_lesson_theme
	 */
	get_party_lesson_information_party_lesson_theme(){
		this.$get("~/api/party_lesson_information/get_list?like=0", { page: 1, size: 10, "party_lesson_theme": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_lesson_information_party_lesson_theme = json.result.list;
			result_party_lesson_information_party_lesson_theme.map(o => o.title = o['party_lesson_theme'])
	  			this.result_party_lesson_information_party_lesson_theme = result_party_lesson_information_party_lesson_theme
		 	}
		});
	},
						/**
	 * 获取type_of_party_courses
	 */
	get_party_lesson_information_type_of_party_courses(){
		this.$get("~/api/party_lesson_information/get_list?like=0", { page: 1, size: 10, "type_of_party_courses": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_lesson_information_type_of_party_courses = json.result.list;
			result_party_lesson_information_type_of_party_courses.map(o => o.title = o['type_of_party_courses'])
	  			this.result_party_lesson_information_type_of_party_courses = result_party_lesson_information_type_of_party_courses
		 	}
		});
	},
																									/**
	 * 获取party_lesson_theme
	 */
	get_sign_in_information_party_lesson_theme(){
		this.$get("~/api/sign_in_information/get_list?like=0", { page: 1, size: 10, "party_lesson_theme": this.query.word }, (json) => {
		  if (json.result) {
			var result_sign_in_information_party_lesson_theme = json.result.list;
			result_sign_in_information_party_lesson_theme.map(o => o.title = o['party_lesson_theme'])
	  			this.result_sign_in_information_party_lesson_theme = result_sign_in_information_party_lesson_theme
		 	}
		});
	},
									/**
	 * 获取party_class_date
	 */
	get_sign_in_information_party_class_date(){
		this.$get("~/api/sign_in_information/get_list?like=0", { page: 1, size: 10, "party_class_date": this.query.word }, (json) => {
		  if (json.result) {
			var result_sign_in_information_party_class_date = json.result.list;
			result_sign_in_information_party_class_date.map(o => o.title = o['party_class_date'])
	  			this.result_sign_in_information_party_class_date = result_sign_in_information_party_class_date
		 	}
		});
	},
																			/**
	 * 获取party_lesson_theme
	 */
	get_leave_information_party_lesson_theme(){
		this.$get("~/api/leave_information/get_list?like=0", { page: 1, size: 10, "party_lesson_theme": this.query.word }, (json) => {
		  if (json.result) {
			var result_leave_information_party_lesson_theme = json.result.list;
			result_leave_information_party_lesson_theme.map(o => o.title = o['party_lesson_theme'])
	  			this.result_leave_information_party_lesson_theme = result_leave_information_party_lesson_theme
		 	}
		});
	},
													/**
	 * 获取department_category
	 */
	get_department_category_department_category(){
		this.$get("~/api/department_category/get_list?like=0", { page: 1, size: 10, "department_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_department_category_department_category = json.result.list;
			result_department_category_department_category.map(o => o.title = o['department_category'])
	  			this.result_department_category_department_category = result_department_category_department_category
		 	}
		});
	},
							/**
	 * 获取student_id
	 */
	get_party_member_information_student_id(){
		this.$get("~/api/party_member_information/get_list?like=0", { page: 1, size: 10, "student_id": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_member_information_student_id = json.result.list;
			result_party_member_information_student_id.map(o => o.title = o['student_id'])
	  			this.result_party_member_information_student_id = result_party_member_information_student_id
		 	}
		});
	},
						/**
	 * 获取full_name
	 */
	get_party_member_information_full_name(){
		this.$get("~/api/party_member_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_member_information_full_name = json.result.list;
			result_party_member_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_party_member_information_full_name = result_party_member_information_full_name
		 	}
		});
	},
												/**
	 * 获取identity
	 */
	get_party_member_information_identity(){
		this.$get("~/api/party_member_information/get_list?like=0", { page: 1, size: 10, "identity": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_member_information_identity = json.result.list;
			result_party_member_information_identity.map(o => o.title = o['identity'])
	  			this.result_party_member_information_identity = result_party_member_information_identity
		 	}
		});
	},
						/**
	 * 获取hospital
	 */
	get_party_member_information_hospital(){
		this.$get("~/api/party_member_information/get_list?like=0", { page: 1, size: 10, "hospital": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_member_information_hospital = json.result.list;
			result_party_member_information_hospital.map(o => o.title = o['hospital'])
	  			this.result_party_member_information_hospital = result_party_member_information_hospital
		 	}
		});
	},
												/**
	 * 获取number_of_active_members_of_the_party
	 */
	get_party_member_information_number_of_active_members_of_the_party(){
		this.$get("~/api/party_member_information/get_list?like=0", { page: 1, size: 10, "number_of_active_members_of_the_party": this.query.word }, (json) => {
		  if (json.result) {
			var result_party_member_information_number_of_active_members_of_the_party = json.result.list;
			result_party_member_information_number_of_active_members_of_the_party.map(o => o.title = o['number_of_active_members_of_the_party'])
	  			this.result_party_member_information_number_of_active_members_of_the_party = result_party_member_information_number_of_active_members_of_the_party
		 	}
		});
	},
																/**
	 * 获取full_name
	 */
	get_certificate_of_achievement_full_name(){
		this.$get("~/api/certificate_of_achievement/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_certificate_of_achievement_full_name = json.result.list;
			result_certificate_of_achievement_full_name.map(o => o.title = o['full_name'])
	  			this.result_certificate_of_achievement_full_name = result_certificate_of_achievement_full_name
		 	}
		});
	},
																									/**
	 * 获取full_name
	 */
	get_suggested_feedback_full_name(){
		this.$get("~/api/suggested_feedback/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_suggested_feedback_full_name = json.result.list;
			result_suggested_feedback_full_name.map(o => o.title = o['full_name'])
	  			this.result_suggested_feedback_full_name = result_suggested_feedback_full_name
		 	}
		});
	},
												
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
					this.get_ordinary_users_student_id();
							this.get_ordinary_users_full_name();
																	this.get_general_manager_student_id();
							this.get_general_manager_manager_name();
																	this.get_site_announcement_announcement_title();
							this.get_site_announcement_release_time();
																				this.get_party_building_information_information_title();
							this.get_party_building_information_information_type();
																							this.get_party_building_activities_activity_name();
							this.get_party_building_activities_activity_type();
																										this.get_party_building_notice_notification_title();
							this.get_party_building_notice_notification_type();
																										this.get_experience_full_name();
																				this.get_thought_full_name();
																				this.get_party_dues_payment_date();
														this.get_party_lesson_information_party_lesson_theme();
							this.get_party_lesson_information_type_of_party_courses();
																										this.get_sign_in_information_party_lesson_theme();
										this.get_sign_in_information_party_class_date();
																				this.get_leave_information_party_lesson_theme();
														this.get_department_category_department_category();
								this.get_party_member_information_student_id();
							this.get_party_member_information_full_name();
													this.get_party_member_information_identity();
							this.get_party_member_information_hospital();
													this.get_party_member_information_number_of_active_members_of_the_party();
																	this.get_certificate_of_achievement_full_name();
																										this.get_suggested_feedback_full_name();
												  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
				  this.get_ordinary_users_student_id();
						  this.get_ordinary_users_full_name();
																  this.get_general_manager_student_id();
						  this.get_general_manager_manager_name();
																  this.get_site_announcement_announcement_title();
						  this.get_site_announcement_release_time();
																			  this.get_party_building_information_information_title();
						  this.get_party_building_information_information_type();
																						  this.get_party_building_activities_activity_name();
						  this.get_party_building_activities_activity_type();
																									  this.get_party_building_notice_notification_title();
						  this.get_party_building_notice_notification_type();
																									  this.get_experience_full_name();
																			  this.get_thought_full_name();
																			  this.get_party_dues_payment_date();
													  this.get_party_lesson_information_party_lesson_theme();
						  this.get_party_lesson_information_type_of_party_courses();
																									  this.get_sign_in_information_party_lesson_theme();
									  this.get_sign_in_information_party_class_date();
																			  this.get_leave_information_party_lesson_theme();
													  this.get_department_category_department_category();
							  this.get_party_member_information_student_id();
						  this.get_party_member_information_full_name();
												  this.get_party_member_information_identity();
						  this.get_party_member_information_hospital();
												  this.get_party_member_information_number_of_active_members_of_the_party();
																  this.get_certificate_of_achievement_full_name();
																									  this.get_suggested_feedback_full_name();
													},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
