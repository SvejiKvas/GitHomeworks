    package ru.innopolis.java.homework09.code;

    import java.util.Arrays;

    public class Race {
        int length;
        String route;
        int prizePool;
        Car[] participants;

        Race() {
            this.route = "unnamed";
            this.participants = new Car[]{};
        }

        Race(
                int length,
                String route,
                int prizePool,
                Car[] participants
        ) {
            this.length = length;
            this.route = route;
            this.prizePool = prizePool;
            this.participants = participants;
        }

        @Override
        public String toString() {
            return String.format("Lenght: %d%n" +
                    "Route: %s%n" +
                    "Prize pool: %d%n" +
                    "Participants: %s%n",
                    this.length, this.route, this.prizePool, showParticipants());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            return length == ((Race) obj).length &&
                    prizePool == ((Race) obj).prizePool &&
                    route.equals(((Race) obj).route) &&
                    Arrays.equals(participants, ((Race) obj).participants);
        }

        @Override
        public int hashCode() {
            int result = 31;
            result = result * 17 + length;
            result = result * 17 + route.hashCode();
            result = result * 17 + prizePool;
            result = result * 17 + Arrays.hashCode(participants);
            return result;
        }

        private String showParticipants () {
            StringBuilder sb = new StringBuilder();
            for (Car cars: participants) {
                sb.append(cars.getMark());
                sb.append(", ");
            }
            if (sb.length() > 2) {
                sb.delete(sb.length() - 2, sb.length());
                return sb.toString();
            }
            else {
                return "it's empty";
            }
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getRoute() {
            return route;
        }

        public void setPrizePool(int prizePool) {
            this.prizePool = prizePool;
        }

        public int getPrizePool() {
            return prizePool;
        }

        public Car[] getParticipants() {
            return participants;
        }

        public void setParticipants(Car[] participants) {
            this.participants = participants;
        }
    }
