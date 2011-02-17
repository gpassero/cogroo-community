package br.usp.ime.cogroo.model.errorreport;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import br.usp.ime.cogroo.model.GrammarCheckerVersion;
import br.usp.ime.cogroo.model.User;

@Entity
public class ErrorEntry {
	
	private static final Logger LOG = Logger.getLogger(ErrorEntry.class);

	@Id
	@GeneratedValue
	private Long id;

	private String text;
	
	private int spanStart;
	
	private int spanEnd;

	@OneToMany(mappedBy = "errorEntry", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@ManyToOne
	private GrammarCheckerVersion version;
	
	@ManyToOne
	private User submitter;

	private Date creation;

	private Date modified;
	
	@OneToOne(mappedBy = "errorEntry", cascade = CascadeType.ALL)
	private GrammarCheckerBadIntervention badIntervention;
	
	@OneToOne(mappedBy = "errorEntry", cascade = CascadeType.ALL)
	private GrammarCheckerOmission omission;
	
	private State state;
	
	private Priority priority;
	
	@Transient
	private boolean isNew = false;

	public ErrorEntry(String text, int start, int end, List<Comment> comments,
			GrammarCheckerVersion version, User submitter, Date creation,
			Date modified, GrammarCheckerBadIntervention badIntervention,
			GrammarCheckerOmission omissions, State state, Priority priority) {
		this.text = text;
		this.spanStart = start;
		this.spanEnd = end;
		this.comments = comments;
		this.version = version;
		this.submitter = submitter;
		this.creation = creation;
		this.modified = modified;
		this.badIntervention = badIntervention;
		this.omission = omissions;
		this.state = state;
		this.priority = priority;
	}

	public ErrorEntry() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Comment> getErrorEntryComments() {
		return comments;
	}

	public void setErrorEntryComments(List<Comment> comments) {
		this.comments = comments;
	}

	public GrammarCheckerVersion getVersion() {
		return version;
	}

	public void setVersion(GrammarCheckerVersion version) {
		this.version = version;
	}

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	public GrammarCheckerBadIntervention getBadIntervention() {
		return badIntervention;
	}

	public void setBadIntervention(GrammarCheckerBadIntervention badIntervention) {
		this.badIntervention = badIntervention;
	}

	public GrammarCheckerOmission getOmission() {
		return omission;
	}

	public void setOmissions(GrammarCheckerOmission omissions) {
		this.omission = omissions;
	}

	public int getSpanStart() {
		return spanStart;
	}

	public void setSpanStart(int spanStart) {
		this.spanStart = spanStart;
	}

	public int getSpanEnd() {
		return spanEnd;
	}

	public void setSpanEnd(int spanEnd) {
		this.spanEnd = spanEnd;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setOmission(GrammarCheckerOmission omission) {
		this.omission = omission;
	}
	
	public State getState() {
		if(state == null) {
			this.state = State.OPEN;
		}
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Priority getPriority() {
		if(priority == null) {
			this.priority = Priority.NORMAL;
		}
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public String getMarkedText() {
		StringBuilder sb = new StringBuilder(this.getText());
		try {
			sb.insert(this.getSpanEnd(), "</span>");
			String type;
			if(getOmission() != null) {
				type = "omission";
			} else {
				type = "badint";
			}
			sb.insert(this.getSpanStart(), "<span class=\"" + type + "\">");
		} catch(StringIndexOutOfBoundsException e) {
			LOG.error("Wrong index: text[" + this.getText() + "]" + " start[" + this.getSpanStart() + "] end[" + this.getSpanEnd() + "]");
		}
		return sb.toString();
	}
	
	public int getCommentCount() {
		int count = 0;
		for (Comment comment : getComments()) {
			count += comment.getCount();
		}
		return count;
	}
	
	@Transient
	public boolean getIsNew() {
		return isNew;
	}
	
	@Transient
	public void setIsNew(boolean value) {
		isNew = value;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "\n");
		sb.append("submitter: " + submitter + "\n");
		sb.append("text: " + text + "\n");
		sb.append("version: " + version + "\n");
		sb.append("creation: " + creation + "\n");
		sb.append("modified: " + modified + "\n");
		sb.append("comments: " + "\n");
		if(comments != null) {
			for (Comment comment : comments) {
				sb.append("   " + comment + "\n");
			}
		}
		return sb.toString();
	}

}
