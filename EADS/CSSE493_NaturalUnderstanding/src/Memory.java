import java.util.Date;

public class Memory {
	String context;
	String incident;
	Date date;
	Memory nextMem;
	Memory prevMem;
	
	public Memory(String incident, Date date) {
		this.incident = incident;
		this.date = date;
		this.nextMem = null;
		this.prevMem = null;
	}
	
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Memory getNextMem() {
		return nextMem;
	}
	public void setNextMem(Memory nextMem) {
		this.nextMem = nextMem;
	}
	public Memory getPrevMem() {
		return prevMem;
	}
	public void setPrevMem(Memory prevMem) {
		this.prevMem = prevMem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memory other = (Memory) obj;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		return true;
	}

}
