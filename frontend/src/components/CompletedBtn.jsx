import { markCompletedApi } from "../api/userApi";
const CompletedBtn = (props) => {
  const { moduleList, userCompletion, currentId ,setCompleted , course , findLessonId} = props;
  let idx = 0;
  moduleList.forEach((ele, i) => {
    if (ele.moduleId == currentId) {
      idx = i;
    }
  });
  let status = userCompletion[0];
  status = status ? status.modulesCompleted[idx] : null;
  const handleCompleted = (e) => {
    e.preventDefault();
    let bodyFormData = new FormData();
    bodyFormData.append("userId", localStorage.getItem("userId"));
    bodyFormData.append("courseId", course.courseId);
    bodyFormData.append("moduleId", findLessonId());
    markCompletedApi(bodyFormData)
      .then((resolve) => {
        console.log(resolve);
        setCompleted(true);
      })
      .catch((err) => console.error(err));
  };

  return (
    <>
      {status
        ? status == false
          ?<button onClick={e => handleCompleted(e)}>Mark as completed</button> 
          : status == true
          ? "Already completed"
          : null
        : null}
    </>
  );
};
export default CompletedBtn;
