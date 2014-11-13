public int getClarityInt()
{
  if(this.getClarity().equals("FL"))
    return 0;
  else if(this.getClarity().equals("IF"))
    return 1;
  else if(this.getClarity().equals("VVS1"))
    return 2;
  else if(this.getClarity().equals("VVS2"))
    return 3;
  else if(this.getClarity().equals("VS1"))
    return 4;
  else if(this.getClarity().equals("VS2"))
    return 5;
  else if(this.getClarity().equals("SI1"))
    return 6;
  else if(this.getClarity().equals("SI2"))
    return 7;
  else if(this.getClarity().equals("I1"))
    return 8;
  else if(this.getClarity().equals("I2"))
    return 9;
  else if(this.getClarity().equals("I3"))
    return 10;
}

public int getColorInt()
{
  if(this.getColor() == 'D' || this.getColor() == 'E')
    return 0;
  else if(this.getColor() == 'F' || this.getColor() == 'G')
    return 1;
  else if(this.getColor() == 'H' || this.getColor() == 'I')
    return 2;
  else if(this.getColor() == 'J' || this.getColor() == 'K')
    return 3;
  else if(this.getColor() == 'L' || this.getColor() == 'M')
    return 4;
  else if(this.getColor() == 'N' || this.getColor() == 'O')
    return 5;
  else if(this.getColor() == 'P' || this.getColor() == 'Q')
    return 6;
  else if(this.getColor() == 'R' || this.getColor() == 'S')
    return 7;
  else if(this.getColor() == 'T' || this.getColor() == 'U')
    return 8;
  else if(this.getColor() == 'V' || this.getColor() == 'W')
    return 9;
  else if(this.getColor() == 'X' || this.getColor() == 'Y')
    return 10;
  else if(this.getColor() == 'Z')
    return 11;
}

public int getCombinedGrade()
{
  // Clarity is better, return it.
  if(this.getClarityInt() < this.getColorInt())
    return this.getClarityInt();
  // Color is better, return it.
  else if(this.getClarityInt() > this.getColorInt())
    return this.getColorInt();
  // Both are equal, return either.
  else
    return this.getClarityInt();
}

public int getWorstGrade()
{
  // Clarity is worse, return it.
  if(this.getClarityInt() > this.getColorInt())
    return this.getClarityInt();
  // Color is worse, return it.
  else if(this.getClarityInt() < this.getColorInt())
    return this.getColorInt();
  // Both are equal, return either.
  else
    return this.getClarityInt();
}

public int compareTo(Diamond other)
{
  if(other.getCarot() > this.getCarot())
    return 1;
  else if(other.getCarot() < this.getCarot())
    return -1;
  else if(other.getCombinedGrade() < this.getCombinedGrade())
    return 1;
  else if(other.getCombinedGrade() > this.getCombinedGrade())
    return -1;
  else if(other.getWorstGrade() < this.getWorstGrade())
    return 1;
  else if(other.getWorstGrade() > this.getWorstGrade())
    return -1;
  else
    return 0;
}

public String toString()
{
  return "Diamond "+this.getStockNumber+"\n"
        +"Carot: "+this.getCarot()+"\n"
        +"Clarity: "+this.getClarity()+"\n"
        +"Color: "+this.getColor()+"\n"
        +"Cut: "+this.getCut()+"\n";
}
