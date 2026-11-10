const tasks = [
  { time: "09:00", title: "DBMS — Chapter 6 reading", detail: "Library · 45 min", type: "academic", done: false },
  { time: "14:00", title: "Finish OOP mini project", detail: "Computer lab · due Thursday", type: "academic", done: false },
  { time: "18:30", title: "Call home", detail: "A small reset", type: "personal", done: false }
];
let filter = "all", spent = 1685, budget = 12000;
const timeline = document.querySelector("#timeline");
const toast = document.querySelector("#toast");

function renderTasks() {
  timeline.innerHTML = tasks.filter(t => filter === "all" || t.type === filter).map((task, index) => `
    <div class="task-row">
      <span class="task-time">${task.time}</span>
      <button class="task-check ${task.done ? "done" : ""}" data-index="${tasks.indexOf(task)}" aria-label="Mark ${task.title} complete"></button>
      <div><div class="task-name" style="${task.done ? "text-decoration:line-through;color:#68718a" : ""}">${task.title}</div><div class="task-detail">${task.detail}</div></div>
      <span class="task-tag ${task.type === "personal" ? "personal" : ""}">${task.type === "academic" ? "Study" : "Personal"}</span>
    </div>`).join("") || '<p class="task-detail">Nothing here yet. Add a small win below.</p>';
}
function notify(message) { toast.textContent = message; toast.classList.add("show"); setTimeout(() => toast.classList.remove("show"), 2500); }
function renderBudget() { document.querySelector("#spent").textContent = `₹${spent.toLocaleString("en-IN")}`; document.querySelector("#remaining").textContent = `₹${(budget-spent).toLocaleString("en-IN")}`; document.querySelector("#budgetFill").style.width = `${Math.min(100, spent / budget * 100)}%`; }
renderTasks(); renderBudget();

timeline.addEventListener("click", e => { const button = e.target.closest(".task-check"); if (!button) return; tasks[button.dataset.index].done = !tasks[button.dataset.index].done; renderTasks(); notify(tasks[button.dataset.index].done ? "Task completed. Nice work." : "Task moved back to your list."); });
document.querySelectorAll(".filter").forEach(button => button.addEventListener("click", () => { filter = button.dataset.filter; document.querySelectorAll(".filter").forEach(b => b.classList.toggle("selected", b === button)); renderTasks(); }));
document.querySelector("#taskForm").addEventListener("submit", e => { e.preventDefault(); const input = document.querySelector("#taskTitle"); tasks.push({ time: "Anytime", title: input.value.trim(), detail: "Added just now", type: document.querySelector("#taskType").value, done: false }); input.value = ""; filter = "all"; document.querySelectorAll(".filter").forEach(b => b.classList.toggle("selected", b.dataset.filter === "all")); renderTasks(); notify("Added to today’s plan."); });
const dialog = document.querySelector("#expenseDialog"); document.querySelector("#expenseBtn").addEventListener("click", () => dialog.showModal());
document.querySelector("#expenseForm").addEventListener("submit", e => { if (e.submitter.value === "cancel") return; e.preventDefault(); const title = document.querySelector("#expenseTitle").value.trim(), amount = Number(document.querySelector("#expenseAmount").value); if (!title || !amount) return; spent += amount; document.querySelector("#expenses").insertAdjacentHTML("afterbegin", `<li><span class="expense-dot"></span><span>${title}<small>Added today</small></span><b>−₹${amount.toLocaleString("en-IN")}</b></li>`); renderBudget(); dialog.close(); e.target.reset(); notify("Expense saved."); });
document.querySelectorAll(".moods button").forEach(button => button.addEventListener("click", () => { document.querySelectorAll(".moods button").forEach(b => b.classList.toggle("chosen", b === button)); document.querySelector("#checkin").textContent = `${button.dataset.mood} noted. Let your plan meet you there.`; }));
document.querySelector("#focusBtn").addEventListener("click", () => notify("Focus sprint started — 25 minutes, one task.")); document.querySelector("#showTasks").addEventListener("click", () => document.querySelector("#schedule").scrollIntoView({behavior:"smooth"}));
